import sys
from collections import deque

input = sys.stdin.readline


# def bfs():
def count_0():
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if tomato[h][i][j] == 0:
                    return 1

    return 0


# get input. N is row, M is col, H is height
M, N, H = map(int, input().split())
tomato = [[] for h in range(H)]
for h in range(H):
    for i in range(N):
        tomato[h].append(list(map(int, input().split())))

dhei = [0, 0, 0, 0, -1, 1]
drow = [-1, 1, 0, 0, 0, 0]  # means delta row
dcol = [0, 0, -1, 1, 0, 0]

# find 1
tomato_1 = []
for h in range(H):
    for i in range(N):
        for j in range(M):
            if tomato[h][i][j] == 1:
                tomato_1.append([h, i, j])

dq = deque(tomato_1)
day = 1

while dq:
    cur_to = dq.popleft()

    for i in range(6):
        nhei = cur_to[0] + dhei[i]
        nrow = cur_to[1] + drow[i]  # means new row
        ncol = cur_to[2] + dcol[i]

        if 0 <= nhei < H and 0 <= nrow < N and 0 <= ncol < M and tomato[nhei][nrow][ncol] == 0:
            tomato[nhei][nrow][ncol] = tomato[cur_to[0]][cur_to[1]][cur_to[2]] + 1
            dq.append([nhei, nrow, ncol])
            day = tomato[nhei][nrow][ncol]

# count 0, if 0 exist, unmatured exists.
if count_0() == 0:
    print(day - 1) # -1 because it stared from 1
else:
    print(-1)

# if done, max is answer