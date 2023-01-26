import sys

def dfs():
    global N,M
    if len(result) == M:
        print(' '.join([str(x) for x in result]))
        return
    for i in range(1, N+1):
        if visit[i]:
            continue
        visit[i] = True
        result.append(i)
        dfs()
        visit[i] = False
        result.remove(i)


N, M = map(int, sys.stdin.readline().strip().split())
result = []
visit = [False] * (N + 1)
dfs()
