import sys

input = sys.stdin.readline


def Belman_Ford():
    global N, M

    for i in range(N):  # Nst loop is to check minus cycle
        for j in edge:  # check all edges every time
            start, end, weight = j[0], j[1], j[2]
            if dist[start] != inf and dist[end] > dist[start] + weight:
                if i == N - 1:
                    return 1
                dist[end] = dist[start] + weight


inf = 10 ** 9
N, M = map(int, input().split())  # N is num of city, M is num of bus
edge = []
for _ in range(M):
    edge.append(list(map(int, input().split())))

dist = [inf] * (N + 1)
dist[1] = 0  # 1 is starting point

minus_cycle = Belman_Ford()

if minus_cycle == 1:
    print(-1)
else:
    for i in range(2, N + 1):
        if dist[i] == inf:
            print(-1)
        else:
            print(dist[i])