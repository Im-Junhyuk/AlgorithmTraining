import sys


def isVPS(PS):
    stack = []
    for j in PS:
        #print(j)
        if j == '(':
            stack.append(0)
        elif j == ')':
            if len(stack) == 0:
                print('NO')
                return
            del stack[-1]
        #print(stack)
    if len(stack) == 0:
        print('YES')
    else:
        print('NO')


T = int(sys.stdin.readline())

for i in range(T):
    PS = sys.stdin.readline()
    isVPS(PS)


