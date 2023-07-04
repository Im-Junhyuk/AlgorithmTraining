import sys
input = sys.stdin.readline

'''
def dp(x, y):
    if x < 0 or y < 0:
        return 0

    if dp_list[x][y]:
        return dp_list[x][y]
    else:
        dp_list[x][y] = dp(x - 1, y) + dp(x, y - 1) - dp(x - 1, y - 1) + mat[x][y]
        return dp_list[x][y]
'''

# get N(size of matrix), M(number of problem)
N, M = map(int, input().split())

# get matrix
dp_list = [[0 for i in range(N+1)] for j in range(N+1)]

for i in range(1, N+1):
    mat = list(map(int, input().split()))
    for j in range(1, N+1):
        dp_list[i][j] = dp_list[i-1][j] + dp_list[i][j-1] - dp_list[i-1][j-1] + mat[j-1]


# get x, y
for i in range(M):
    x1, y1, x2, y2 = map(int, input().split())

    print(dp_list[x2][y2] - dp_list[x1-1][y2] - dp_list[x2][y1-1] + dp_list[x1-1][y1-1])
# print(*dp_list)
