# from sys import stdin
import sys
from collections import deque



def bfs(node) :
    q = deque()
    q.append(node)
    check[node] = 1
    while q :
        node = q.popleft()
        for i in graph[node] :
            if check[n] == 0 :
                check[n] = 1
                q.append(i)
#
n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]

for _ in range(m) :
    a, b = map(int, sys.stdin.readline().split())
    graph[b].append(a)

result = []

for i in range(1, n+1) :
    check = [0]*(n+1)
    bfs(i)
    result.append(check.count(1))

m = max(result)

for i in range(n) :
    if result[i] == m :
        print(i+1, end=" ")
print()


# def bfs(v) :
#     q = deque(v)
#     visited = [False] * (n+1)
#     count = 1
#     while q :
#         v = q.popleft()
#         for e in adj[v] :
#             if not visited[e] :
#                 q.append(e)
#                 visited[e] = True
#                 print(visited)
#                 count += 1
#
#     return count
#
#
#
# n, m = map(int, stdin.readline().split())
# adj = [[] for _ in range(n+1)]
#
# for _ in range(m) :
#     a, b = map(int, stdin.readline().split())
#     adj[b].append(a)
#     print(adj)
#
# result = []
# max_value = -1
#
# for i in range(1, n+1) :
#     c = bfs(i)
#     if c>max_value :
#         max_value = c
#         result = [i]
#     elif c == max_value :
#         result.append(i)
#
# for j in result :
#     print(j, end=" ")