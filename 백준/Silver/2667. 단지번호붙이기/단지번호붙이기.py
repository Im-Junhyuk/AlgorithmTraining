import sys

input = sys.stdin.readline


def dfs(i, j):

    global now_house, group_num, house_by_group

    # check it is in range
    if i < 0 or i > N - 1 or j < 0 or j > N - 1:
        return

    if visited[i][j] == 1:
        return

    #print(i, j, ground[i][j])
    visited[i][j] = 1

    # check it is house.
    if ground[i][j] == '1':
        if now_house == 0:
            now_house = 1
            group_num += 1
            house_num[i][j] = group_num
            house_by_group.append(1)
        else:
            house_num[i][j] = group_num
            house_by_group[group_num] += 1

        dfs(i + 1, j)
        dfs(i, j + 1)
        dfs(i, j - 1)
        dfs(i - 1, j)




N = int(input())
ground = []  # house or not
group_num = 0  # house group num
now_house = 0  # ground checked 0, house 1.
house_by_group = [0]
visited = [[0] * N for x in range(N)]
house_num = [[0] * N for x in range(N)]

for i in range(N):
    ground.append(input().strip())

for i in range(N):
    for j in range(N):
        #if visited[i][j] == 0 and ground[i][j] == '1':
        dfs(i, j)
        now_house = 0

print(group_num)
house_by_group.sort()
for i in range(1, group_num + 1):
    print(house_by_group[i])


#print(house_by_group)
