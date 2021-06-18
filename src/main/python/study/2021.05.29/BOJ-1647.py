import sys

import sys

input = sys.stdin.readline
N, M = map(int, input().split())
parent = [0] * (N + 1)
graph = []

for i in range(1, N + 1):
    parent[i] = i


def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return parent[x]


def unite(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for _ in range(M):
    a, b, cost = map(int, input().split())
    graph.append((cost, a, b))
graph.sort()
result = 0
last = 0

for edge in graph:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        unite(parent, a, b)
        result += cost
        last = cost

print(result - last)
