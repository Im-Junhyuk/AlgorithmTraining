import sys

def dfs():
    if len(result) == M:
        print(' '.join([str(x) for x in result]))
        return
    for i in range(1, N+1):
        if result:
            if i < max(result):
                continue
        result.append(i)
        dfs()
        result.pop()


N , M = map(int, sys.stdin.readline().strip().split())
result = []
dfs()
