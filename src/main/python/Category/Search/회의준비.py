import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
K = int(input())


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)

    if a == b:
        return
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


parent = [0] * (N + 1)

for i in range(1, N + 1):
    parent[i] = i

graph = [[0] * (N + 1) for _ in range(N + 1)]
lst = defaultdict(list)

for i in range(K):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)
    graph[a][b] = 1
    graph[b][a] = 1

for i in lst:
    lst[i].sort()


def dfs(x, count):
    count += 1
    visited[x] = True
    for j in range(1, N + 1):
        if graph[x][j] == 1 and not visited[j]:
            dfs(j, count)


for i in range(1, N + 1):
    count = 0
    visited = [False for _ in range(N + 1)]
    if not visited[i]:
        dfs(i, count)

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if graph[i][j] == 1:
            union_parent(parent, i, j)
# 10^8
# 내부에 변수를 하나 둬서 -> 파라미터를 추가로 둬서.(Depth)
print(lst)
print(parent)
new_parent = set(parent[1:])
print(list(new_parent))

for i in new_parent:
    answer = 0
    for j in parent:
        answer = max(answer, len(parent[j]))









