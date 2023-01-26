import sys

def is_in_list(list, key, start, end):
    mid = (start + end) // 2
    if start > end:
        return 0
    if key == list[mid]:
        return 1
    if key > list[mid]:
        return is_in_list(list, key, mid + 1, end)
    else:
        return is_in_list(list, key, start, mid - 1)

N = int(sys.stdin.readline())
N_list = list(map(int, sys.stdin.readline().strip().split()))

M = int(sys.stdin.readline())
M_list = list(map(int, sys.stdin.readline().strip().split()))

N_list.sort()

for i in M_list:
    print(is_in_list(N_list, i, 0, N-1), end = ' ')