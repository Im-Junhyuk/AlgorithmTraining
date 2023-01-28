import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline


def dfs(v):
    global visited_num
    visited_num += 1
    visited[v] = visited_num

    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)


N, M, R = map(int, input().split())
graph = [[] for x in range(N + 1)]

visited = [0 for x in range(N + 1)]  # v[0] is exeption, 0 means unvisited, positive is v seq
visited_num = 0

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
    # x to y, y to x

for i in graph:
    i.sort()

dfs(R)

for i in range(1, N + 1):
    print(visited[i])