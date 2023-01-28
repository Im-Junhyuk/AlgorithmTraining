import sys


def d_and_c(start_r, start_c, length):
    global white_num, blue_num

    # same color?
    color = paper[start_r][start_c]
    color_num = 1
    for i in range(start_r, start_r + length):
        for j in range(start_c, start_c + length):
            if color != paper[i][j]:
                color_num = 2
                break

    # if yes, pass. record color
    if color_num == 1:
        if color == 0:
            white_num += 1
        else:
            blue_num += 1

    # if not, d_and_c
    else:
        d_and_c(start_r, start_c, length // 2)
        d_and_c(start_r + length // 2, start_c, length // 2)
        d_and_c(start_r, start_c + length // 2, length // 2)
        d_and_c(start_r + length // 2, start_c + length // 2, length // 2)


N = int(input())
paper = []
for i in range(N):
    paper.append(list(map(int, sys.stdin.readline().split())))

white_num = 0
blue_num = 0

d_and_c(0, 0, N)
print(white_num)
print(blue_num)