import sys
from collections import deque

test_case = int(input())
for i in range(test_case):
    N, M = map(int, sys.stdin.readline().split())  # N is tatal number, M is index
    priority = deque(list(map(int, sys.stdin.readline().split())))
    cnt = 0

    while True:
        if M == 0:
            if priority[0] == max(priority):
                print(cnt + 1)
                break
            else:
                priority.rotate(-1)
                M = len(priority) - 1
        elif priority[0] == max(priority):
            priority.popleft()
            M -= 1
            cnt += 1
        else:
            priority.rotate(-1)
            M -= 1
