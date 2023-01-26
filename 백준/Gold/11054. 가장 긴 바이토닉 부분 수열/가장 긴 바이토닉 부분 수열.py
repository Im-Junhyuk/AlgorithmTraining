N = int(input().strip())
A = list(map(int, input().strip().split()))

dp_lis = [1 for x in range(N)]
dp_lis_inc = [1 for x in range(N)]
dp_lis_dec = [1 for x in range(N)]

# increasing sequence 0 to i
for i in range(N):
    for j in range(i):
        if A[j] < A[i] and dp_lis_inc[j] >= dp_lis_inc[i]:
            dp_lis_inc[i] = dp_lis_inc[j] + 1

# decreasing sequence i to N-1
for i in range(N - 1, -1, -1):
    for j in range(N - 1, i, -1):
        if A[i] > A[j] and dp_lis_dec[j] >= dp_lis_dec[i]:
            dp_lis_dec[i] = dp_lis_dec[j] + 1

for i in range(N):
    dp_lis[i] = dp_lis_inc[i] + dp_lis_dec[i] - 1

print(max(dp_lis))
#print(dp_lis_dec)
#print(dp_lis_inc)
#print(dp_lis)