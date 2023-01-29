N = int(input())
A = list(map(int, input().split()))

lis = [[] for x in range(N)]
lis_length = [1] * N

for i in range(0, N):
    lis[i].append(A[i])

for i in range(0, N):
    for j in range(0, i):
        if A[i] > A[j] and lis_length[j] >= lis_length[i]:
            lis[i] = lis[j] + [A[i]]
            lis_length[i] = lis_length[j] + 1

max_lis_length = max(lis_length)
print(max_lis_length)
print(*lis[lis_length.index(max_lis_length)])
