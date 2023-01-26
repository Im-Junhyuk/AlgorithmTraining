import sys
def recursion(s, l, r):
    global recur_num
    recur_num += 1
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: return recursion(s, l+1, r-1)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1)

case_num = int(sys.stdin.readline())

for i in range(case_num):
    recur_num = 0
    S = sys.stdin.readline().strip()
    print(isPalindrome(S), recur_num)
    