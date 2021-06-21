import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
parent = [0] * (N + 1)
for i in range(N + 1):
    parent[i] = i

for i in range(M):
    a, b, cost = map(int, input().split())
    graph[a].append([cost, b])

graph.sort()


def find_parent(parent, x):
    if parent[x] != x:
        find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

result = 0
for i in graph :
    print(i)



# input = sys.stdin.readline
#
# N = int(input())
# M = int(input())
# graph = []
# parent = [0] * (N + 1)
#
# for i in range(1, N + 1):
#     parent[i] = i
#
# for i in range(1, M + 1):
#     cost, a, b = map(int, input().split())
#     graph.append((cost, a, b))
#
#
# def find_parent(parent, x):
#     if parent[x] != x:
#         return find_parent(parent, parent[x])
#     return parent[x]
#
#
# def unite_parent(parent, x, y):
#     a = find_parent(parent, x)
#     b = find_parent(parent, y)
#     if a < b:
#         parent[b] = a
#     else:
#         parent[a] = b
#
#
# graph.sort()
# result = 0
#
# for edge in graph:
#     cost, a, b = edge
#     if find_parent(parent, a) != find_parent(parent, b):
#         unite_parent(parent, a, b)
#         result += cost
#
# print(result)
