mat = [list(map(int,input().split())) for i in range(9)]
biggest = -1
index_x = -1
index_y = -1
for i in range(9):
    for j in range(9):
        if mat[i][j] > biggest:
            index_x = i
            index_y = j
            biggest = mat[i][j]
print(biggest)
print(index_x + 1, index_y + 1, sep = ' ')