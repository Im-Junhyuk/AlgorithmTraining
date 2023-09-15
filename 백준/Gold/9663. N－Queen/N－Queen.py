import sys


def isvalid(x, y):

    global n

    # 가능한지 확인
    for a in range(0, x):
        if chess_board[a] == y or (x - a) == abs(y - chess_board[a]):
            return False
    return True


def n_queen(x):
    global ans, n
    #print(x, ans, chess_board)
    # 탈출
    if x == n:
        ans += 1
        return

    for y in range(n):
        if isvalid(x, y):
            # 다음 호출
            chess_board[x] = y
            n_queen(x + 1)

    # -1, 종료
    chess_board[x] = -1

input = sys.stdin.readline

n = int(input().strip())
ans = 0
chess_board = [-1 for _ in range(n)]
# value가 y 좌표. -1은 없음

n_queen(0)

print(ans)

