def mat_mul(mat1, mat2):
    temp = [[0] * 2 for x in range(2)]

    for i in range(2):
        for j in range(2):
            cur_value = 0
            for k in range(2):
                cur_value += mat1[i][k] * mat2[k][j] % 1000000007
            temp[i][j] = cur_value

    return temp


def fib(n):

    if n == 1:
        return result

    temp = fib(n // 2)
    if n % 2:
        return mat_mul(mat_mul(temp, temp), result)
    else:
        return mat_mul(temp, temp)


n = int(input())

result = [[1,1], [1,0]]
if n == 0:
    print(0)
else:
    result = fib(n)
    print(result[0][1]% 1000000007)