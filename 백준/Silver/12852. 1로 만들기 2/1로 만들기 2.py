def dp(K):
    for i in range(2, K + 1):

        temp = []
        if i % 3 == 0:
            temp.append([cnt[i // 3] + 1, i // 3])

        if i % 2 == 0:
            temp.append([cnt[i // 2] + 1, i // 2])

        temp.append([cnt[i - 1] + 1, i - 1])

        temp.sort()

        cnt[i] = temp[0][0]
        route[i] = route[temp[0][1]] + [i]


N = int(input())
inf = 10 ** 6
cnt = [inf] * (N + 1)
route = [[] for _ in range(N + 1)]

# init
cnt[1] = 0
route[1].append(1)

dp(N)
print(cnt[N])
for i in range(len(route[N]) - 1, -1, -1):
    print(route[N][i], end=' ')
# print(*route)


