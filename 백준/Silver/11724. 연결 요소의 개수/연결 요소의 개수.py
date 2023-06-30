# n, m 입력 받기
n, m = map(int, list(input().split()))

# edge 입력 받기
graph = [[0 for i in range(n+1)] for j in range(n+1)]
for _ in range(m):
    start, end = map(int, list(input().split()))
    graph[start][end] = 1
    graph[end][start] = 1

# dfs로 컨포넌트 나누기
compo_num = 0
visited = [0 for i in range(n+1)]
stack = []

for start in range(1, n+1):
    if visited[start] == 0:
        compo_num += 1
        visited[start] = compo_num
        stack.append(start)

        while stack:
            point = stack.pop()
            for i in range(1, n+1):
                if visited[i] == 0 and graph[point][i]:
                    visited[i] = compo_num
                    stack.append(i)

# 컴포넌트 번호 최대치 출력
print(compo_num)
# print(visited)