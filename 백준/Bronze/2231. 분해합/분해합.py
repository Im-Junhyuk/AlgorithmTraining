def find_constructor(num):
    for i in range(num+1):
        j = i
        num_list = []
        while j>0:
            k = j%10
            j = j//10
            num_list.append(k)
        if sum(num_list) + i == num:
            return i
    return 0
    
num = int(input())    
print(find_constructor(num))