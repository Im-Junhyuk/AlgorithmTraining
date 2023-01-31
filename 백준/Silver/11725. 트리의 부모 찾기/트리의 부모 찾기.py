import sys
import collections

sys.setrecursionlimit(10**9)
input = sys.stdin.readline


def dfs(node):
    visited[node] = 1
    for i in edge_dict[node]:
        if visited[i] == 0:
            parent[i] = node
            #print(parent)
            dfs(i)




# init
vertex_num = int(input())
edge_dict = collections.defaultdict(list)
parent = [0] * (vertex_num + 1)  # index is 0 to ver_num. 0 and 1 is meaningless.
visited = [0] * (vertex_num + 1)  # 0 is unvisited. 1 is visited.
# get input, make tree
for _ in range(vertex_num - 1):
    v1, v2 = map(int, input().split())
    edge_dict[v1].append(v2)
    edge_dict[v2].append(v1)

dfs(1)

for i in range(2, vertex_num + 1):
    print(parent[i])
