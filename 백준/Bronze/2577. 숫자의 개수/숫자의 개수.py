num_list = []
num = 1
for i in range(3):
    num_input = int(input())
    num *= num_input

num = str(num)

for i in range(10):
    print(num.count(str(i)))
