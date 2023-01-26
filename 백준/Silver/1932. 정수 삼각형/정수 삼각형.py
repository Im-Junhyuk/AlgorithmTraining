import sys

n = int(input().strip())

result = [0]

for i in range(1, n + 1):
    input_list = list(map(int, sys.stdin.readline().strip().split()))
    temp_result = []
    for j in range(0, i):
        if j == 0:
            temp_result.append(result[j] + input_list[j])
        elif 0 < j and j < i - 1:
            temp_result.append(max(result[j - 1], result[j]) + input_list[j])
        elif j == i - 1:
            temp_result.append(result[j - 1] + input_list[j])
    result = temp_result
print(max(result))