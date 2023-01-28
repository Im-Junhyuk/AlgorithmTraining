import sys

N, M = map(int, sys.stdin.readline().split())
mat_a = []
for i in range(N):
    mat_a.append(list(map(int, sys.stdin.readline().split())))

M, K = map(int, sys.stdin.readline().split())
mat_b = []
for i in range(M):
    mat_b.append(list(map(int, sys.stdin.readline().split())))

answer = [[0 for x in range(K)] for y in range(N)]

for i in range(N):
    for j in range(K):
        cur_value = 0
        for k in range(M):
            cur_value += mat_a[i][k] * mat_b[k][j]
        answer[i][j] = cur_value
        #print(answer[i][j])
for i in answer:
    print(*i)