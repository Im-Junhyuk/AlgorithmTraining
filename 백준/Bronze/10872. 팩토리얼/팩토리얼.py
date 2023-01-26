import sys
def facto(num):
    if num == 0:
        return 1
    return num * facto(num - 1)
    
num = int(sys.stdin.readline())
print(facto(num))