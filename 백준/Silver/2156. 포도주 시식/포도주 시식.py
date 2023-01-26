import sys

n = int(input().strip())
wine_list = [0]
for i in range(n):
    wine_list.append(int(sys.stdin.readline().strip()))
    # 0~n-1

# i = (i-3) + (i-1) + i or i = (i-3) + (i-2) + i
# init
wine_volume = [0 for x in range(n+1)]
if n <=2:
    print(sum(wine_list))
else:
    wine_volume[1] = wine_list[1]
    wine_volume[2] = wine_list[1] + wine_list[2]
#print(wine_volume)
# running
    for i in range(3, n+1):
        wine_volume[i] = max(wine_list[i] + wine_volume[i-2],wine_list[i] + wine_volume[i-3] + wine_list[i-1], wine_volume[i-1])
    #print(wine_volume)

    print(max(wine_volume))
#print(wine_volume)
