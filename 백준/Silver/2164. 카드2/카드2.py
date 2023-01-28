from collections import deque
N = int(input())

queue = deque([x for x in range(1, N+1)])
for i in range(0, N-1):
    queue.popleft()
    queue.rotate(-1)
    
print(queue.popleft())