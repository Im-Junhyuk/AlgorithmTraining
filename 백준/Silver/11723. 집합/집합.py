import sys

input = sys.stdin.readline


def add(x):
    S.add(x)


def remove(x):
    S.remove(x)


def check(x):
    if x in S:
        print(1)
    else:
        print(0)


def toggle(x):
    if x in S:
        remove(x)
    else:
        add(x)

def all():
    global S
    S = set([i for i in range(1, 21)])

def empty():

    S.clear()


M = int(input())
S = set()
for i in range(M):
    input_list = list(input().split())
    inst = input_list[0]

    if len(input_list) == 2:
        num = int(input_list[1])
    # print(input_list)
    # print(S)
    if inst == 'add':
        add(num)
    elif inst == 'remove':
        if num in S:
            remove(num)
    elif inst == 'check':
        check(num)
    elif inst == 'toggle':
        toggle(num)
    elif inst == 'all':
        all()
    elif inst == 'empty':
        empty()

