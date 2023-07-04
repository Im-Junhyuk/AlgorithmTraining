def dfs():
    global M
    if len(result) == M:
        result_list.add(tuple(result))
        return

    for i in range(N):
        if used[i] == 1:
            continue
        result.append(input_list[i])
        used[i] = 1
        dfs()
        used[i] = 0
        result.pop()


N, M = map(int, input().split())
input_list = list(map(int, input().split()))
input_list.sort()

result = []
used = [0 for i in range(N)]
result_list = set()

dfs()

result_list = list(result_list)
result_list.sort()

for i in result_list:
    print(' '.join(map(str, i)))
