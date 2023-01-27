import sys

input = sys.stdin.readline

inf = 10 ** 9
V, E = map(int, input().split())
graph = [[inf] * (V + 1) for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for x in range(1, V + 1):
    for i in range(1, V + 1):
        for j in range(1, V + 1):
            graph[i][j] = min(graph[i][j], graph[i][x] + graph[x][j])

min_cycle = inf
for i in range(1, V + 1):
    min_cycle = min(min_cycle, graph[i][i])

if min_cycle == inf:
    print(-1)
else:
    print(min_cycle)
