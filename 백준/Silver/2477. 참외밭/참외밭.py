import sys

K = int(sys.stdin.readline().strip())
for_d = 0
made_small_s = 0
large_s = [0] * 5
small_s = [0] * 2
for i in range(6):
    cur_d, len = map(int, sys.stdin.readline().strip().split())
    if for_d == 0:
        fir_len = len
    if for_d == 0 or (for_d == 1 and cur_d == 4) or (for_d == 2 and cur_d == 3) or (for_d == 3 and cur_d == 1) or (
            for_d == 4 and cur_d == 2):
        large_s[cur_d] = len
    else:
        small_s[0] = large_s[for_d]
        small_s[1] = len
        made_small_s += 1
    for_d = cur_d
    
if made_small_s ==0:
    small_s[0] = fir_len
    small_s[1] = len
    
print(K * (max(large_s[1], large_s[2]) * max(large_s[3], large_s[4]) - small_s[0] * small_s[1]))