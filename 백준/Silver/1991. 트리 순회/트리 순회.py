import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline


def preorder(v):
    print(v, end='')
    if graph[v][0] != '.':
        preorder(graph[v][0])
    if graph[v][1] != '.':
        preorder(graph[v][1])


def inorder(v):
    if graph[v][0] != '.':
        inorder(graph[v][0])
    print(v, end='')
    if graph[v][1] != '.':
        inorder(graph[v][1])


def postorder(v):
    if graph[v][0] != '.':
        postorder(graph[v][0])
    if graph[v][1] != '.':
        postorder(graph[v][1])
    print(v, end='')


num_v = int(input())
graph = defaultdict(list)

for _ in range(num_v):
    start, left, right = input().split()
    graph[start].extend([left, right])

preorder('A')
print()

inorder('A')
print()

postorder('A')
print()