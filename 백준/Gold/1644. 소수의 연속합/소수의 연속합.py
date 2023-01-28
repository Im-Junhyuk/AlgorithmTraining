N = int(input())

# get prime num less than or equal to N
prime = []
num = [False] * 2 + [True] * (N - 1)

for i in range(N + 1):
    if num[i]:
        prime.append(i)
        for j in range(2 * i, N + 1, i):
            num[j] = False

cnt = 0
start, end = 0, 0
sum = 0

while True:
    if sum < N:
        end += 1
        if end > len(prime):
            break
        sum += prime[end-1]
    elif sum > N:
        sum -= prime[start]
        start += 1
    else:
        cnt += 1
        sum -= prime[start]
        start += 1

print(cnt) 