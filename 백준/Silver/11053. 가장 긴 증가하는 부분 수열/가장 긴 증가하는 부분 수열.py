N = int(input().strip())

A = list(map(int,input().strip().split()))

dp_lis = [1 for x in range(N)]

for i in range(0, N):
    for j in range(0, i):
        if A[i] > A[j] and dp_lis[i] <= dp_lis[j]:
            dp_lis[i] = dp_lis[j] + 1

print(max(dp_lis))