import sys

N, M = map(int, sys.stdin.readline().strip().split())
num_dict = {}
name_dict = {}
#print(N, M)
for poke_num in range(1, N + 1):
    poke_name = sys.stdin.readline().strip()
    num_dict[str(poke_num)] = poke_name
    name_dict[poke_name] = poke_num

#print(num_dict, sep = '\n')
#print(name_dict, sep = '\n')
for j in range(M):
    key = sys.stdin.readline().strip()
    if key.isdigit():
        print(num_dict[key])
    if key.isalpha():
        print(name_dict[key])
