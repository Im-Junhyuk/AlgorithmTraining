num = int(input())
if num == 1:
    print()
num_to_divide = 2
while num != 1:
    if num % num_to_divide ==0:
        print(num_to_divide)
        num = num //num_to_divide
    else:
        num_to_divide += 1
