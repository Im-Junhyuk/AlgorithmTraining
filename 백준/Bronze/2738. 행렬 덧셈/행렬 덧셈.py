row, column = map(int,input().split())

mat1 = [list(map(int,input().split())) for i in range(row)]

mat2 = [list(map(int,input().split())) for i in range(row)]

for i in range(row):
    for j in range(column):
        print(mat1[i][j] + mat2[i][j], end = ' ')
    