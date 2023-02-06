import sys

sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline


def dfs(v):
    visited[v] = 1

    for chil in graph[v]:
        if visited[chil[0]] == 0:
            visited[chil[0]] = 1
            dist[chil[0]] = dist[v] + chil[1]
            dfs(chil[0])


V = int(input())
graph = [[] for _ in range(V + 1)]
for i in range(V):
    cur_input = list(map(int, input().split()))
    for j in range(1, len(cur_input) - 1, 2):
        graph[cur_input[0]].append([cur_input[j], cur_input[j + 1]])

# farthest v1 from any v
visited = [0] * (V + 1)  # 0 means unvisited
dist = [0] * (V + 1)
dfs(1)
v1 = dist.index(max(dist))

# farthest v2 from v1
visited = [0] * (V + 1)
dist = [0] * (V + 1)
dfs(v1)

# print dist from v1 to v2

print(max(dist))
