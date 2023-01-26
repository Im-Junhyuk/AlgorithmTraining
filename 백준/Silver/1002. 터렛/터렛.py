import sys

T = int(sys.stdin.readline())
for i in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
    k = ((x1-x2)**2 + (y1-y2)**2)**(0.5)
    if k == 0:
        if r1 == r2:
            print(-1)
        else: 
            print(0)
    elif k < abs(r1 - r2):
        print(0)
    elif k == abs(r1 - r2):
        print(1)
    elif r1 + r2 > k > abs(r1 - r2):
        print(2)
    elif r1 + r2 == k:
        print(1)
    else:
        print(0)