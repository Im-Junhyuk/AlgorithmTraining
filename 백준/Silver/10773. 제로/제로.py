import sys

K = int(sys.stdin.readline())
stack = []

for i in range(K):
    num = int(sys.stdin.readline())
    if num == 0:
        del stack[-1]
    else:
        stack.append(num)

print(sum(stack))