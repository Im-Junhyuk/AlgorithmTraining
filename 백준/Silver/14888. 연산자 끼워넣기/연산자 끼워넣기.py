def dfs(cur_num, depth, add, sub, mul, div):
    if add + sub + mul + div == 0:
        result_list.append(cur_num)
    if add > 0:
        dfs(cur_num + num[depth], depth + 1, add - 1, sub, mul, div)
    if sub > 0:
        dfs(cur_num - num[depth], depth + 1, add, sub - 1, mul, div)
    if mul > 0:
        dfs(cur_num * num[depth], depth + 1, add, sub, mul - 1, div)
    if div > 0:
        if cur_num >= 0:
            dfs(cur_num // num[depth], depth + 1, add, sub, mul, div - 1)
        else:
            dfs(-(-cur_num // num[depth]), depth + 1, add, sub, mul, div - 1)

N = int(input())

num = list(map(int, input().split()))
op = list(map(int, input().split()))
result_list = []
dfs(num[0], 1, op[0], op[1], op[2], op[3])
print(max(result_list))
print(min(result_list))