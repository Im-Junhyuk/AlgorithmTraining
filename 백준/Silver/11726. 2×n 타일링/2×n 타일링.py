import math

# 입력
n = int(input())

# 2의 최대 개수 구하기
num_2 = n // 2

# 1이 있는지 구하기
num_1 = n % 2

# sum 선언
sum = 0

# 2의 개수를 줄이며 합 구하기
while num_2 >= 0:
    sum += math.comb(num_1+num_2, num_2)
    num_2 -= 1
    num_1 += 2
# 출력
print(sum%10007)