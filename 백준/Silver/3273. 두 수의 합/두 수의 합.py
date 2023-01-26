import sys

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
x = int(input())

a.sort()
start = 0
end = n - 1
pair = 0


while start < end:
    #print(sum)
    sum = a[start] + a[end]
    if x < sum:
        end -= 1
    elif x > sum:
        start += 1
    else:
        pair += 1
        start += 1
        end -= 1
print(pair)