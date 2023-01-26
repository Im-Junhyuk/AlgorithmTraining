biggest = 0
for i in range(1,10):
    current_num = int(input())
    if current_num > biggest:
        biggest = current_num
        biggest_index = i
        
print(biggest)
print(biggest_index)