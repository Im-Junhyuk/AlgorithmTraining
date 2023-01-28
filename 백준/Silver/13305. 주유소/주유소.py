city = int(input())
dist = list(map(int, input().split()))
oil_value = list(map(int, input().split()))
cur_min_oil = oil_value[0]

total_cost = cur_min_oil * dist[0]

for i in range(1, city - 1):
    cur_min_oil = min(cur_min_oil, oil_value[i])
    total_cost += cur_min_oil * dist[i]

print(total_cost)