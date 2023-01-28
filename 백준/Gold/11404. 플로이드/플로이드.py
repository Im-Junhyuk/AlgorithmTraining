import sys

input = sys.stdin.readline

n = int(input())  # num of city
m = int(input())  # num of bus
inf = 10**9

# graph index is from 1 to m
graph = [[inf for x in range(n + 1)] for y in range(n + 1)]
for i in range(m):
    u, v, w = map(int, input().split())
    if w < graph[u][v]:
        graph[u][v] = w

# weight i to i is 0
for i in range(1, n + 1):
    graph[i][i] = 0

for v in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][v] + graph[v][j])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if graph[i][j] == inf:
            print(0, end=' ')
        else:
            print(graph[i][j], end=' ')
    print()
