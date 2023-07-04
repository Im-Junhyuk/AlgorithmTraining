import sys
from collections import defaultdict
import heapq

input = sys.stdin.readline

# N : num of vertex
# M : num of edge
# X : destination

# get input
N, M, X = map(int, input().split())

# one way edge, default edge is -1, suppose to start at distination.
edge_to_dest = defaultdict(list)
edge_from_dest = defaultdict(list)

for i in range(M):
    start, end, distance = map(int, input().split())
    edge_to_dest[end].append([distance, start])
    edge_from_dest[start].append([distance, end])

# cal dist respectively
# 1. dist to dest
# init
heap = [[0, X]]
dist_to_dest = defaultdict(int)

while heap:
    dist, vertex = heapq.heappop(heap)
    if vertex not in dist_to_dest:
        dist_to_dest[vertex] = dist
        for i in edge_to_dest[vertex]:
            heapq.heappush(heap, [i[0] + dist, i[1]])

# 2. dist from dest
# init
heap = [[0, X]]
dist_from_dest = defaultdict(int)

while heap:
    dist, vertex = heapq.heappop(heap)
    if vertex not in dist_from_dest:
        dist_from_dest[vertex] = dist
        for i in edge_from_dest[vertex]:
            heapq.heappush(heap, [i[0] + dist, i[1]])

# get max
two_way_dest = defaultdict(int)
for i in dist_to_dest.keys():
    two_way_dest[i] = dist_to_dest[i] + dist_from_dest[i]

print(max(two_way_dest.values()))
# print(dist_to_dest)
# print(dist_from_dest)
# print(two_way_dest)