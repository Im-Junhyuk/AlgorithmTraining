N, S = map(int, input().split())

list = list(map(int, input().split()))

start, end = 0, 0

sum = list[start]
gap = 100000

while end >= start:

    if S > sum:
        end += 1
        if N == end:
            break
        sum += list[end]
    else:
        gap = min(gap, end - start + 1)
        #print(gap, start, end)
        sum -= list[start]
        start += 1

if gap == 100000:
    print(0)
else:
    print(gap)