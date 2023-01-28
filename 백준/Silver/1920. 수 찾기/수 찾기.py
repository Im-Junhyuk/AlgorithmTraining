def bi_search(start, end, key):
    mid = (start + end) // 2
    if start > end:
        print(0)
        return

    if N_list[mid] == key:
        print(1)
        return
    elif N_list[mid] > key:
        bi_search(start, mid - 1, key)
    else:
        bi_search(mid + 1, end, key)


N = int(input())
N_list = list(map(int, input().split()))
M = int(input())
M_list = list(map(int, input().split()))

N_list.sort()
#print(N, N_list, M, M_list)
for i in range(M):
    bi_search(0, N - 1, M_list[i])
