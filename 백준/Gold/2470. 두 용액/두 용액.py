import sys

input = sys.stdin.readline

N = int(input())

ph = list(map(int, input().split()))

ph.sort()
min_abs_ph = 2000000000
small, big = 0, 0
start = 0
end = N - 1

while start < end:
    sum = ph[start] + ph[end]
    abs_sum = abs(sum)
    if abs_sum < min_abs_ph:
        min_abs_ph = abs_sum
        small = start
        big = end

    if sum > 0:
        end -= 1
    elif sum < 0:
        start += 1
    else:
        break

print(ph[small], ph[big])
