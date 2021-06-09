import sys

input = sys.stdin.readline
INF = 1e9
N, M = map(int, input().split())
graph = [[INF] * (N + 1) for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

X, K = map(int, input().split())

result = 0

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if graph[i][j] != 1:
            graph[i][j] = INF

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            graph[i][j] = 0

# for i in range(1, N+1) :
#     for j in range(1, N+1) :
#         for