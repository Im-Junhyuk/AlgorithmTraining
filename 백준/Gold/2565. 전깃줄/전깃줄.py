import sys

num = int(input())
line = []
for i in range(num):
    line.append(list(map(int,sys.stdin.readline().split())))
    
line.sort()
dp_line = [1 for x in range(num)]

for i in range(num):
    for j in range(i):
        if line[j][1] < line[i][1] and dp_line[i] <= dp_line[j]:
            dp_line[i] = dp_line[j] + 1
            
print(num - max(dp_line))