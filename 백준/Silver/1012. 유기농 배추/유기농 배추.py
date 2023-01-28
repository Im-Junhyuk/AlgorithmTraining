import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline


def dfs(i, j):
    global now_cabbage, group_num
    if i >= N or i < 0 or j >= M or j < 0 or visited[i][j] == 1:
        return

    visited[i][j] = 1

    if cabbage[i][j] == 1:
        if now_cabbage == 0:
            now_cabbage = 1
            group_num += 1
        else:
            pass

        cabbage[i][j] = group_num
        dfs(i - 1, j)
        dfs(i + 1, j)
        dfs(i, j + 1)
        dfs(i, j - 1)


T = int(input())

for test in range(T):
    M, N, K = map(int, input().split())  # M is column length, N is row, K is cabbage
    cabbage = [[0] * M for i in range(N)]
    visited = [[0] * M for i in range(N)]

    now_cabbage = 0  # now looking at cabbage
    group_num = 0

    for c in range(K):
        col, row = map(int, input().split())
        cabbage[row][col] = 1

    # start dfs
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0:
                dfs(i, j)
            now_cabbage = 0

    print(group_num)

