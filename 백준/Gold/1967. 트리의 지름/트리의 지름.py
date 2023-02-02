import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline


def dfs(node):
    visited[node] = 1
    for v, l in graph[node]:
        if visited[v] == 0:
            visited[v] = 1
            length[v] = length[node] + l
            dfs(v)


n = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    v1, v2, length = map(int, input().split())
    graph[v1].append([v2, length])
    graph[v2].append([v1, length])

# find most far v from root
length = [0] * (n + 1)
visited = [0] * (n + 1)  # visited[0] is garbage, 0 is unvisited. 1 is visited.
# revised to length
# init
dfs(1)


farthest = length.index(max(length))
length = [0] * (n + 1)
visited = [0] * (n + 1)

dfs(farthest)

print(max(length))


