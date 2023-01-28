import sys


def mat_mul(mat1, mat2):
    temp = [[0] * N for x in range(N)]

    for i in range(N):
        for j in range(N):
            cur_value = 0
            for k in range(N):
                cur_value += mat1[i][k] * mat2[k][j] %1000
            temp[i][j] = cur_value

    return temp


def get_mat(A, B):

    if B == 1:
        return A

    temp = get_mat(A, B // 2)
    if B % 2:
        return mat_mul(mat_mul(temp, temp), A)
    else:
        return mat_mul(temp, temp)


N, B = map(int, sys.stdin.readline().split())
A = []
for i in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))

for i in range(N):
    for j in range(N):
        A[i][j] = A[i][j] % 1000

answer = [[1] * N for y in range(N)]

answer = get_mat(A, B)

for i in range(N):
    for j in range(N):
        answer[i][j] = answer[i][j] % 1000

for i in answer:
    print(*i)