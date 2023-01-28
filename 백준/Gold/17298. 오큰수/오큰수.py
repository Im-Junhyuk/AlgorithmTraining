N = int(input())
A = list(map(int, input().split()))

stack = []  # index of element that don't have NGE
NGE = [-1 for x in range(N)]  # default value is -1

# init
stack.append(0)

for i in range(1, N):
    while stack and A[stack[-1]] < A[i]:
        NGE[stack.pop()] = A[i]
    stack.append(i)
    #print(stack)
print(*NGE)