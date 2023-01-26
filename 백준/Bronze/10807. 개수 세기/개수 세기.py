num_of_num = int(input())

num_array = list(map(int,input().split()))

v = int(input())

num_of_v = 0
for i in range(0,num_of_num):
    if num_array[i] == v:
        num_of_v += 1
        
print(num_of_v)