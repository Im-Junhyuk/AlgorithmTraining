list = []
for i in range(5):
    list.append(int(input()))
    
list.sort()
print(int(sum(list)/len(list)))
print(list[2])