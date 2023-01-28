import sys


def d_and_c(start_r, start_c, length):

    # same num?
    num = paper[start_r][start_c]
    how_many_num = 1
    for i in range(start_r, start_r + length):
        for j in range(start_c, start_c + length):
            if num != paper[i][j]:
                how_many_num = 2
                break

    # if yes, pass. record color
    if how_many_num == 1:
        if num == -1:
            num_record[0] += 1
        if num == 0:
            num_record[1] += 1
        elif num == 1:
            num_record[2] += 1

    # if not, d_and_c
    else:
        d_and_c(start_r, start_c, length // 3)
        d_and_c(start_r, start_c + length // 3, length // 3)
        d_and_c(start_r, start_c + length // 3 * 2, length // 3)
        
        d_and_c(start_r + length // 3, start_c, length // 3)
        d_and_c(start_r + length // 3, start_c + length // 3, length // 3)
        d_and_c(start_r + length // 3, start_c + length // 3 * 2, length // 3)
        
        d_and_c(start_r + length // 3 * 2, start_c, length // 3)
        d_and_c(start_r + length // 3 * 2, start_c + length // 3, length // 3)
        d_and_c(start_r + length // 3 * 2, start_c + length // 3 * 2, length // 3)
        
        
N = int(input())
paper = []
for i in range(N):
    paper.append(list(map(int, sys.stdin.readline().split())))

num_record = [0,0,0] #num of -1, 0, 1

d_and_c(0, 0, N)
for i in range(3):
    print(num_record[i])