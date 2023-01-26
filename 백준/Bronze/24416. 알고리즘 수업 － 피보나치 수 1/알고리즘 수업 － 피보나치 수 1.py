import sys

'''
def fib(num):
    global fib_num

    if num == 1 or num == 2:
        fib_num += 1
        return 1
    else:
        return fib(num - 1) + fib(num - 2)
'''

def fib(num):
    global fib_num
    f = []
    f.append(None)
    f.append(1)
    f.append(1)
    for i in range(3, num + 1):
        f.append(f[i - 1] + f[i - 2] )
    return f[num]

'''
def fib(n):
    if n==1 or n==2:        
        return 1
    else:
        global fin_num
        fib_num += 1
        return fib(n-1) + fib(n-2)
'''

num = int(sys.stdin.readline())
fib_num = 0
fib(num)
print(fib(num), num - 2)

