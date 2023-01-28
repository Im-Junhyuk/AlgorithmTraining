import sys
import collections
import heapq

input = sys.stdin.readline

N, K = map(int, input().split())

heap = []
heapq.heappush(heap, [0, N])
dist = collections.defaultdict(int)

while heap:
    cur_time, cur_pos = heapq.heappop(heap)
    if cur_pos in dist:
        continue

    dist[cur_pos] = cur_time

    if cur_pos == K:
        break

    # x-1, x+1, 2x
    if cur_pos < K:

        new_pos = 2 * cur_pos
        if new_pos <= 100001 and new_pos not in dist:
            heapq.heappush(heap, [cur_time, new_pos])

        new_pos = cur_pos + 1
        if new_pos <= 100000:
            heapq.heappush(heap, [cur_time + 1, new_pos])

    new_pos = cur_pos - 1
    if 0 <= new_pos:
        heapq.heappush(heap, [cur_time + 1, new_pos])

print(dist[K])