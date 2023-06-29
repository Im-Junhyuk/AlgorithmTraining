import sys

input = sys.stdin.readline

# 입력 받아 2차원 배열에 저장
n = int(input())
edge = int(input())

com = [[0 for i in range(n + 1)] for j in range(n + 1)]

for i in range(edge):
    start, end = map(int, list(input().split()))
    com[start][end] = 1
    com[end][start] = 1

# 1에서 감염 시작 감염시키는 컴 번호를 큐에 저장 감염된 번호를 리스트에 저장

now_addicted = [1]
totally_addicted = []
already_addicted = [0] * (n+1)
# print(already_addicted)
already_addicted[1] = 1

while now_addicted:
    addicted = now_addicted.pop()
    totally_addicted.append(addicted)

    for i in range(1, n + 1):
        if com[addicted][i] and already_addicted[i] == 0:
            now_addicted.append(i)
            already_addicted[i] = 1
    # print(now_addicted)
# 리스트에서 감염된 수 출력
print(len(totally_addicted)-1)

