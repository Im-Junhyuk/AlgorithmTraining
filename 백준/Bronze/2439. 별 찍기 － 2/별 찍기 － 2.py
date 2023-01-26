N = int(input())
str_N = str(N)
str1 = ''
for i in range(1, N+1):
    str1 = str1 + '*'
    print(str1.rjust(N))