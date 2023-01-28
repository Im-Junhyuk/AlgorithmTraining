import sys
from collections import deque

input = sys.stdin.readline


N, M = map(int, input().split())
maze = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for i in range(N):
    maze.append(input())  # maze is list of str

# 0,0 to N-1,M-1 BFS
# list [row, col, num_of_v]
visited = [[0] * M for x in range(N)]
dq = deque([[0, 0, 1]])
while dq:
    cur_list = dq.popleft()

    # print(*cur_list)
    if cur_list[0] == N - 1 and cur_list[1] == M - 1:
        print(cur_list[2])
        break

    for i in range(4):
        n_row = cur_list[0] + dx[i]
        n_col = cur_list[1] + dy[i]

        if n_row < 0 or n_row >= N or n_col < 0 or n_col >= M or visited[n_row][n_col] == 1:
            continue
        elif maze[n_row][n_col] == '1':
            visited[n_row][n_col] = 1
            dq.append([n_row, n_col, cur_list[2] + 1])

