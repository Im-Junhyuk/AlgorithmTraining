#0:1칸 올라온 경우 = 2칸 올라가야 함
#1:2칸 올라온 경우 = 1칸 올라가도 됨
import sys

stair = []
stair_num = int(input().strip())
for i in range(stair_num):
    stair.append(int(sys.stdin.readline().strip()))

dp_stair = []

if stair_num == 1:
    print(stair[0])
elif stair_num == 2:
    print(stair[0]+stair[1])
else:
    dp_stair.append([stair[0], 0])
    dp_stair.append([dp_stair[0][0] + stair[1], stair[1]])
    #dp_stair.append([dp_stair[1][1]+stair[2], dp_stair[0] + stair[2]])

    for i in range(2, stair_num):
        dp_stair.append([dp_stair[i - 1][1] + stair[i], max(dp_stair[i - 2]) + stair[i]])

    print(max(dp_stair[stair_num - 1]))