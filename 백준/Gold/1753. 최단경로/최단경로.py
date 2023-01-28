import collections
import heapq
import sys

input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())

edge = collections.defaultdict(list)

for i in range(E):
    u, v, w = map(int, input().split())
    edge[u].append([v, w])

dist = collections.defaultdict(int)
queue = []
heapq.heappush(queue, [0, K])

while queue:
    cur_dist, vertex = heapq.heappop(queue)
    if vertex not in dist:
        dist[vertex] = cur_dist
        for v, d in edge[vertex]:
            if v not in dist:
                # new_d =
                heapq.heappush(queue, [d + cur_dist, v])

for i in range(1, V + 1):
    if i in dist:
        print(dist[i])
    else:
        print('INF')
# print(*dist)
