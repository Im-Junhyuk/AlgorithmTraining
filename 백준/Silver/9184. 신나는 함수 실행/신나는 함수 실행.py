import sys


def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
    elif dp_list[a][b][c] is not None:
        return dp_list[a][b][c]
    elif a < b < c:
        dp_list[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return dp_list[a][b][c]
    else:
        dp_list[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        return dp_list[a][b][c]


dp_list = [[[None] * 21 for i in range(21)] for i in range(21)]

a = None
b = None
c = None
while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1 and c == -1:
        break
    print('w(%d, %d, %d) = %d' % (a, b, c, w(a, b, c)))




