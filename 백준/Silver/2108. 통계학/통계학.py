import sys

# 입력받기
N = int(sys.stdin.readline().strip())
list = []
for i in range(N):
    list.append(int(sys.stdin.readline().strip()))

# 산술평균
print(round(sum(list) / N))

# 중앙값
list.sort()
print(list[(N - 1) // 2])

# 최빈값
# -4000~4000 -> 0~8000
new_list = [x + 4000 for x in list]
count_list = [0] * 8001

for i in range(N):
    count_list[new_list[i]] += 1

max_value = max(count_list)
max_list = []

for i in range(8001):
    if count_list[i] == max_value:
        max_list.append(i)

if len(max_list) == 1:
    print(max_list[0] - 4000)# 0~8000 -> -4000~4000
else:
    max_list.sort()
    print(max_list[1] - 4000)

# 범위
print(max(list) - min(list))
