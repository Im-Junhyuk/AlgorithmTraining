import sys


def P(N):
    if pado[N]:
        return pado[N]
    if N == 1 or N == 2 or N == 3:
        pado[N] = 1
        return 1
    pado[N] = P(N - 3) + P(N - 2)
    return pado[N]


T = int(sys.stdin.readline())
pado = [None] * 101

for i in range(1, T + 1):
    N = int(sys.stdin.readline())
    print(P(N))