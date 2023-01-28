import sys
from collections import deque

input = sys.stdin.readline


def bfs() -> int:

    global I

    dq = deque([sp])
    move = [1, 2]

    while dq:
        cp = dq.popleft()

        if sp == cp:
            chess_board[cp[0]][cp[1]] = 0

        if cp == ep:
            return chess_board[cp[0]][cp[1]]

        next_move = chess_board[cp[0]][cp[1]] + 1
        for i in range(2):
            x = (-1) ** i
            for j in range(2):
                y = (-1) ** j
                row = x * move[0] + cp[0]
                col = y * move[1] + cp[1]
                if 0 <= row < I and 0 <= col < I and chess_board[row][col] == -1:
                    dq.append([row, col])
                    chess_board[row][col] = next_move

                row = x * move[1] + cp[0]
                col = y * move[0] + cp[1]
                if 0 <= row < I and 0 <= col < I and chess_board[row][col] == -1:
                    dq.append([row, col])
                    chess_board[row][col] = next_move


T = int(input())

for test in range(T):
    I = int(input())
    sp = list(map(int, input().split()))
    ep = list(map(int, input().split()))
    chess_board = [[-1 for x in range(I)] for y in range(I)]
    # move = 0

    print(bfs())
    #print(chess_board)
