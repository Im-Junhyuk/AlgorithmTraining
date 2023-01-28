import sys


def push(x):
    stack.append(x)


def pop():
    if len(stack) == 0:
        print(-1)
    else:
        print(stack.pop(-1))


def size():
    print(len(stack))


def empty():
    if len(stack) == 0:
        print(1)
    else:
        print(0)


def top():
    if len(stack) == 0:
        print(-1)
    else:
        print(stack[-1])


N = int(sys.stdin.readline())
stack = []
for i in range(N):
    inst = sys.stdin.readline().strip()
    if inst == 'pop':
        pop()
    elif inst == 'size':
        size()
    elif inst == 'empty':
        empty()
    elif inst == 'top':
        top()
    else:  # push X
        inst, value = inst.split()
        push(value)
