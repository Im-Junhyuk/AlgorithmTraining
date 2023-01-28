import sys

S = input().strip()
q = int(input().strip())

alpha_num = [[0 for x in range(len(S) + 1)] for y in range(26)]
# a's ascii is 97, z has 122 convert to 0 to 25
for i in range(1, len(S)+1):
    alpha_num[ord(S[i - 1]) - 97][i] = 1
    for j in range(26):
        alpha_num[j][i] += alpha_num[j][i-1]
for i in range(q):
    al, l, r = sys.stdin.readline().split()
    l = int(l)
    r = int(r)
    # include ends
    # if 0, 4 -> s[1], s[5] -> s[5] - s[0]
    al_ascii = ord(al) - 97
    print(alpha_num[al_ascii][r + 1] - alpha_num[al_ascii][l])
