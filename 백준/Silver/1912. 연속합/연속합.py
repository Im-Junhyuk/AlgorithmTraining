import sys

n = int(sys.stdin.readline())
list_num = list(map(int, sys.stdin.readline().split()))
list_dp = [None] * n
list_dp[0] = list_num[0]

for i in range(1, n):
    list_dp[i] = max(list_num[i], list_dp[i - 1] + list_num[i])
print(max(list_dp))