import sys
from collections import deque

input = sys.stdin.readline


# implement bfs
def Bfs():
    while len(dq):

        point = dq.pop()
        x = point[0]
        y = point[1]

        # 확인
        if visited[x][y] == 1:
            continue
        visited[x][y] = 1

        # 상하좌우 점에 갈 수 있고, 비방문이라면 큐에 추가, 거리 계산
        new_dist = dist[x][y] + 1
        if x - 1 >= 0 and visited[x - 1][y] == 0:
            if land[x - 1][y] == 1:
                dist[x - 1][y] = new_dist
                dq.appendleft([x - 1, y])
            else:
                dist[x - 1][y] = 0

        if x + 1 <= n - 1 and visited[x + 1][y] == 0:
            if land[x+1][y] == 1:
                dist[x + 1][y] = new_dist
                dq.appendleft([x + 1, y])
            else:
                dist[x + 1][y] = 0

        if y - 1 >= 0 and visited[x][y - 1] == 0:
            if land[x][y-1] == 1:
                dist[x][y - 1] = new_dist
                dq.appendleft([x, y - 1])
            else:
                dist[x][y - 1] = 0

        if y + 1 <= m - 1 and visited[x][y + 1] == 0:
            if land[x][y+1] == 1:
                dist[x][y + 1] = new_dist
                dq.appendleft([x, y + 1])
            else:
                dist[x][y + 1] = 0


# 세로 n, 가로 m 입력
n, m = map(int, input().split())

# n개의 줄에 m개의 숫자.
# 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.
land = list()
visited = [[0 for i in range(m)] for j in range(n)]  # 0 = unvisited

# declare dist default value is -1(unreached)
dist = [[-1 for i in range(m)] for j in range(n)]

for i in range(n):
    input_line = list(map(int, input().split()))
    land.append(input_line)
    for j in range(len(input_line)):
        if input_line[j] == 0:
            dist[i][j] = 0
        if input_line[j] == 2:
            starting = (i, j)

# declare deque
dq = deque()

# initialization
dq.appendleft(list(starting))
dist[starting[0]][starting[1]] = 0


# bfs
Bfs()

# print
for i in range(n):
    print(' '.join(list(map(str, dist[i]))))

