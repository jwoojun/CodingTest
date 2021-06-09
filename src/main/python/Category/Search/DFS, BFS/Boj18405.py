import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())

graph = []
data = []
for i in range(N):
    graph.append(list(map(int, input().split())))
    for j in range(N):
        if graph[i][j] != 0:
            data.append((graph[i][j], 0, i, j))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

data.sort()
q = deque(data)
S, X, Y = map(int, input().split())
while q:
    virus, s, x, y = q.popleft()
    if s == S:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx and nx < N and ny >= 0 and ny < N:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s + 1, nx, ny))

print(graph[X - 1][Y - 1])
