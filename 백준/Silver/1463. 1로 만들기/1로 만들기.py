def dp(N):
    if N == 1:
        return 0
    if N == 2:
        return 1
    #print(N, num)
    temp_list = []
    if N % 3 == 0:
        temp_list.append(dp_list[N//3]+1)
    if N % 2 == 0:
        temp_list.append(dp_list[N//2]+1)
    temp_list.append(dp_list[N-1]+1)
    return min(temp_list)


N = int(input().strip())
dp_list = [0]
for i in range(1, N+1):
    dp_list.append(dp(i))
print(dp_list[N])
