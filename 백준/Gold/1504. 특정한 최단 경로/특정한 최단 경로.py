import sys
import collections
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())

graph = collections.defaultdict(list)

for g in range(E):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])
    graph[v].append([u, w])

v1, v2 = map(int, input().split())

# dik from v1 to 1, N, v2
dist_v1 = collections.defaultdict(int)

heap_v1 = []
heapq.heappush(heap_v1, [0, v1])

while heap_v1:
    dist, v = heapq.heappop(heap_v1)
    if v not in dist_v1:
        dist_v1[v] = dist

        for desti, w in graph[v]:
            heapq.heappush(heap_v1, [w + dist, desti])

# dik from v2 to 1, N, v1
dist_v2 = collections.defaultdict(int)
heap_v2 = []

heapq.heappush(heap_v2, [0, v2])

while heap_v2:
    dist, v = heapq.heappop(heap_v2)
    if v not in dist_v2:
        dist_v2[v] = dist

        for desti, w in graph[v]:
            heapq.heappush(heap_v2, [w + dist, desti])

# compare if exists
# both of them exist or all don't
if 1 in dist_v1 and v2 in dist_v1 and V in dist_v2:
    print(min(dist_v1[1] + dist_v1[v2] + dist_v2[V], dist_v2[1] + dist_v2[v1] + dist_v1[V]))
else:
    print(-1)

#print(dist_v1)
#print(dist_v2)