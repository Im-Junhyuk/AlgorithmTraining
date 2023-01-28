from collections import deque


def bfs(N):
    global K
    dq = deque([N])

    while dq:
        cur_point = dq.popleft()
        for i in [cur_point - 1, cur_point + 1, 2 * cur_point]:
            if i < 0 or i > 100000 or vertex[i] != -1:
                continue
            else:
                if i == K:
                    return vertex[cur_point] + 1

                dq.append(i)
                vertex[i] = vertex[cur_point] + 1


N, K = map(int, input().split())
if N == K:
    print(0)
else:
    vertex = [-1 for x in range(100001)]
    vertex[N] = 0

# N is starting point, 1 means starting time
# K is end point

    print(bfs(N))