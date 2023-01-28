N = int(input())
A = list(map(int, input().split()))

stack = []  # index of element that don't have NGE
NGE = [-1 for x in range(N)]  # default value is -1

# init
# count how one value encounter
count_list = [0 for x in range(1000001)]
for i in A:
    count_list[i] += 1

stack.append(0)

for i in range(1, N):
    while stack and count_list[A[stack[-1]]] < count_list[A[i]]:
        NGE[stack.pop()] = A[i]
    stack.append(i)
    #print(stack)
    #print(*NGE)
print(*NGE)
