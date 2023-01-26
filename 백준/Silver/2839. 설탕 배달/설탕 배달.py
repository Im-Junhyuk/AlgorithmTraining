weight = int(input())

num5 = weight //5
rest_for_3 = weight %5
while num5 >= 0:
    if rest_for_3 % 3 == 0:
        break
    num5 -= 1
    rest_for_3 += 5
if num5 >= 0:
    print(num5 + rest_for_3//3)
else:
    print(-1)