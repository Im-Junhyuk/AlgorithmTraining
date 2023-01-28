import sys

K, N = map(int, sys.stdin.readline().split())
len_list = []
for i in range(K):
    len_list.append(int(sys.stdin.readline()))

start = 1
end = max(len_list)
while end >= start:
    line_num = 0
    mid = (start + end) // 2
    for i in len_list:
        line_num += i // mid

    if line_num >= N:
        start = mid +1
    else:
        end = mid -1

print(end)