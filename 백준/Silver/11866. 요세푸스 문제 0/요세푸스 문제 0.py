from collections import deque

N, K = map(int, input().split())
yosepus = []
queue = deque([x for x in range(1, N + 1)])
while len(queue) != 0:
    queue.rotate(-(K - 1))
    yosepus.append(queue.popleft())

print('<', end='')
print(*yosepus, sep=', ', end='')
print('>')