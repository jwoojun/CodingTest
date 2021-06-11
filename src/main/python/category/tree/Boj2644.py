from collections import deque


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
parent = [0] * (n + 1)
parent_copy = [0] * (n + 1)

personA, personB = map(int, input().split())

m = int(input())

for i in range(1, n + 1) :
    parent[i] = i
    parent_copy[i] = i

graph = [[] for _ in range(n + 1)]
q = deque(graph)
result = []

for i in range(1, m + 1):
    a, b = map(int, input().split())
    union_parent(parent, a, b)
    print(a, b)

for i in range(1, n + 1):
    if parent[personA] == parent[i]:
        result.append(parent_copy[i])

if parent[personA] == parent[personB]:
    for i in range(1, n + 1):
        result.append(parent_copy[i])
    print(result)
else:
    print(-1)
print(parent)
