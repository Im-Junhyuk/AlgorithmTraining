import sys
from collections import deque


def func(p):
    global queue
    dq = deque(queue)
    #print(*dq)
    r_cnt = 0
    for i in p:
        if i == 'R':
            r_cnt += 1
        elif i == 'D':
            if len(dq) == 0:
                return 0
            elif r_cnt % 2 == 0:
                dq.popleft()
            else:
                dq.pop()
    if r_cnt % 2 == 1:
        dq.reverse()

    queue = list(dq)
    return 1


T = int(sys.stdin.readline())
for i in range(T):
    p = sys.stdin.readline()
    arr_num = int(sys.stdin.readline())
    queue = sys.stdin.readline().strip()
    if arr_num > 0:
        queue = queue[1:-1]
        queue = list(map(int, queue.split(',')))
    else:
        queue = []

    result = func(p)
    if result == 1:
        print('[', end='')
        print(*queue, sep = ',', end = '')
        print(']')
    elif result == 0:
        print('error')

