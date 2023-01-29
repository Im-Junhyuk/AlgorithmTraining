def bi_search(start, end, value):
    while start < end:
        # print(start, end, value)
        mid = (start + end) // 2
        # print(mid)
        if cur_lis[mid] > value:
            # print("value가 더 작음")
            end = mid
            continue
        elif cur_lis[mid] < value:
            start = mid + 1
            # print("value가 더 큼")
            continue
        else:
            return mid
    # print(end)
    return end


N = int(input())
A = list(map(int, input().split()))

lis = []
# lis_length = [1] * N

for i in range(0, N):
    lis.append([A[i]])

# init
# max_lis_length = 1
cur_lis = [A[0]]

for i in range(1, N):

    if A[i] > cur_lis[-1]:
        cur_lis.extend([A[i]])
        #print(i, cur_lis)
        # max_lis_length += 1
    else:
        cur_lis[bi_search(0, len(cur_lis) - 1, A[i])] = A[i]
        #print(i, cur_lis)

print(len(cur_lis))
# print(max_lis_length)
# print(*lis[lis_length.index(max_lis_length)])