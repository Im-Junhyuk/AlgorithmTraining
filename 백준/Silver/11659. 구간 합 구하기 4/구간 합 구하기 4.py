import sys

N, M = map(int, input().split())
num_list = list(map(int, input().split()))

for i in range(1, N):
    num_list[i] += num_list[i - 1]

num_list = [0] + num_list   # num_list[n] mean sum of 1st to nth

for k in range(M):
    i, j = map(int, sys.stdin.readline().split())  # in index, sum of
    print(num_list[j] - num_list[i - 1])