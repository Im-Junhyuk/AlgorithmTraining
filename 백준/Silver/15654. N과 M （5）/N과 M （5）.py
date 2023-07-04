def dfs():
    global M
    if len(result) == M:
        print(' '.join(map(str, result)))
        return
    for i in range(N):
        if used[i] == 1:
            continue
        result.append(input_list[i])
        used[i] = 1
        dfs()
        used[i] = 0
        result.remove(input_list[i])


# 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
# 둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

N, M = map(int, input().split())
input_list = list(map(int, input().split()))

input_list.sort()

result = []
used = [0 for i in range(N)]  # already used in that one -> 1

dfs()