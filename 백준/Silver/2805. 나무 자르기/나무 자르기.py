def bi_search(start, end, key):
    global M

    mid = (start + end) // 2
    length_sum = 0
    #print(start, end, mid)
    for i in tree:
        if i > mid:
            length_sum += i - mid

    if end < start:
        print(end)
    else:
        if length_sum >= M:
            bi_search(mid + 1, end, key)
        else:
            bi_search(start, mid - 1, key)


N, M = map(int, input().split())

tree = list(map(int, input().split()))

# max_length = sun(tree)
longest_tree = max(tree)

bi_search(0, longest_tree, N)