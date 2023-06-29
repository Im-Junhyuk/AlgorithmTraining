def dp(num):
    if num == 1:
        return dp_list[1]
    elif num == 2:
        return dp_list[2]
    elif num == 3:
        return dp_list[3]

    if dp_list[num] != 0:
        return dp_list[num]
    dp_list[num] = dp(num - 3) + dp(num - 2) + dp(num - 1)
    return dp_list[num]


import sys

input = sys.stdin.readline

n = int(input())
dp_list = [0] * 12
dp_list[1] = 1
dp_list[2] = 2
dp_list[3] = 4

for i in range(n):
    num = int(input())
    print(dp(num))

# print(dp_list)
