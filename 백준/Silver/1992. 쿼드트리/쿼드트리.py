import sys


def quad_tree(start_row, start_col, length):
    # have one color?
    color_num = 1
    color = video[start_row][start_col]
    for i in range(start_row, start_row + length):
        for j in range(start_col, start_col + length):
            if color != video[i][j]:
                color_num = 2
                break
    # yes. print
    if color_num == 1:
        print(color, end = '')
    # no. reccursion
    else:
        print('(', end='')
        quad_tree(start_row, start_col, length // 2)
        quad_tree(start_row, start_col + length // 2, length // 2)
        quad_tree(start_row + length // 2, start_col, length // 2)
        quad_tree(start_row + length // 2, start_col + length // 2, length // 2)
        print(')', end='')


N = int(sys.stdin.readline())
video = []

for i in range(N):
    video.append(sys.stdin.readline())

quad_tree(0, 0, N)