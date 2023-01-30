import bisect
import copy

N = int(input())
A = list(map(int, input().split()))

# init
cur_lis = [A[0]]
lis_record = [0 for x in range(N)]

# when append, max_lis = cur_lis.append

for i in range(1, N):
    if A[i] > cur_lis[-1]:
        cur_lis.append(A[i])
        lis_record[i] = len(cur_lis) - 1
    else:
        lis_record[i] = bisect.bisect_left(cur_lis, A[i])
        cur_lis[lis_record[i]] = A[i]

print(len(cur_lis))
#print(lis_record)

cur_index = len(cur_lis) - 1
result = []
for i in range(len(lis_record) - 1, -1, -1):
    if lis_record[i] == cur_index:
        result.append(A[i])
        cur_index -= 1

result.reverse()
print(*result)