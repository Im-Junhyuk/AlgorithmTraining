import copy

N = int(input().strip())

#0에서 9로 끝나는 인접수의 수
a_list = [0, 1,1,1,1,1,1,1,1,1]
temp_list = [0] *10

for i in range(2, N+1):
    temp_list[0] = a_list[1]
    for j in range(1,9):
        temp_list[j] = a_list[j-1] + a_list[j+1]
    temp_list[9] = a_list[8]
    a_list = copy.deepcopy(temp_list)
print(sum(a_list)%1000000000)
        
        