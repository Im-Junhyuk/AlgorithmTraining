import sys
import heapq

input = sys.stdin.readline

N = int(input())
heap = []
for _ in range(N):
    heapq.heappush(heap, int(input()))

sum = 0

while len(heap) != 1:
    first = heapq.heappop(heap)
    second = heapq.heappop(heap)
    new = first + second
    sum += new
    heapq.heappush(heap, new)

print(sum)
