import sys
from collections import deque

input = sys.stdin.readline


# def bfs():
def count_0():
    for i in range(N):
        for j in range(M):
            if tomato[i][j] == 0:
                return 1

    return 0


# get input. M is col, N is row
tomato = []
M, N = map(int, input().split())
for i in range(N):
    tomato.append(list(map(int, input().split())))

drow = [-1, 1, 0, 0]  # means delta row
dcol = [0, 0, -1, 1]

# find 1
tomato_1 = []
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 1:
            tomato_1.append([i, j])

dq = deque(tomato_1)

while dq:
    cur_to = dq.popleft()

    for i in range(4):
        nrow = cur_to[0] + drow[i]  # means new row
        ncol = cur_to[1] + dcol[i]

        if 0 <= nrow < N and 0 <= ncol < M and tomato[nrow][ncol] == 0:
            tomato[nrow][ncol] = tomato[cur_to[0]][cur_to[1]] + 1
            dq.append([nrow, ncol])

# count 0, if 0 exist, unmatured exists.
if count_0() == 0:
    print(max(map(max, tomato)) - 1) # -1 because it stared from 1
else:
    print(-1)

# if done, max is answer