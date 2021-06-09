n, m = 5, 5
INF = 1e9

graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            graph[i][j] = 0

# a에서 b로 가는 비용 c
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for a in range(1, n + 1):
    for b in range(1, n + 1):
        for c in range(1, n + 1):
            graph[b][c] = min(graph[b][c], graph[b][a] + graph[a][c])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if graph[i][j] == INF:
            print("INFINITY", end=' ')
        else :
            print(graph[i][j], end=' ')
    print()