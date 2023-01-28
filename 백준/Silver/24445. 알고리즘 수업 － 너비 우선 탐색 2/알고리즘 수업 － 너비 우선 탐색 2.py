import sys
from collections import deque

input = sys.stdin.readline


def bfs(v):
    visited_num = 1
    visited[v] = visited_num
    bfs_queue.append(v)

    while bfs_queue:
        cur_v = bfs_queue.popleft()
        for i in edge[cur_v]:
            if visited[i] == 0:
                visited_num += 1
                visited[i] = visited_num
                bfs_queue.append(i)

bfs_queue = deque([])
N, M, R = map(int, input().split())

edge = [[] for x in range(N + 1)]  # index 0 to N. 0 is invalid
visited = [0 for x in range(N + 1)]  # 0 to N. 0 is invalid.
# value 0 means unvisited. p_num mean seq
# visited_num = 0

for i in range(M):
    x, y = map(int, input().split())
    edge[x].append(y)
    edge[y].append(x)

for i in edge:
    i.sort(reverse = True)

bfs(R)
for i in range(1, N + 1):
    print(visited[i])