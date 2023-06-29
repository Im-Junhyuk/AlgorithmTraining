num = int(input())
suc_list = int(input())
sum = 0

for i in range(num):
    sum = sum + suc_list % 10
    suc_list = suc_list // 10

print(sum)