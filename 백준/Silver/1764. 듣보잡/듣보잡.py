import sys

input = sys.stdin.readline

num_d, num_b = map(int, list(input().strip().split()))

d = set()
for i in range(num_d):
    d.add(input().strip())

b = set()
for i in range(num_b):
    b.add(input().strip())

d_b = d & b

list_d_b = list(d_b)
list_d_b.sort()

print(len(list_d_b))
for i in range(len(list_d_b)):
    print(list_d_b[i])