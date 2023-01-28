import sys
from collections import deque 

def isempty():
    if len(queue) == 0:
        return 1
    else:
        return 0


def push(x):
    queue.append(x)


def pop():
    if isempty() == 1:
        print(-1)
    else:
        print(queue.popleft())


def size():
    print(len(queue))


def empty():
    if len(queue) == 0:
        print(1)
    else:
        print(0)


def front():
    if isempty() == 1:
        print(-1)
    else:
        print(queue[0])


def back():
    if isempty() == 1:
        print(-1)
    else:
        print(queue[-1])


N = int(sys.stdin.readline())
queue = deque([])
for i in range(N):
    inst = sys.stdin.readline().strip()
    if inst == 'pop':
        pop()
    elif inst == 'size':
        size()
    elif inst == 'empty':
        empty()
    elif inst == 'front':
        front()
    elif inst == 'back':
        back()

    else:
        inst, x = inst.split()
        if inst == 'push':
            push(x)
