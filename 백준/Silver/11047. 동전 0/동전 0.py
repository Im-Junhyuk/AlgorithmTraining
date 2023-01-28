import sys

N, K = map(int, sys.stdin.readline().split())
coin_value = []
for i in range(N):
    coin_value.append(int(sys.stdin.readline()))

coin_num = 0
coin = -1
while K > 0:
    coin_num += K // coin_value[coin]
    K = K % coin_value[coin]
    coin = coin - 1

print(coin_num)