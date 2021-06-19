# 음식물 피하기
import sys

sys.setrecursionlimit(100000)

input = sys.stdin.readline

N, M, K = map(int, input().split())
graph = [[0 for i in range(M)] for j in range(N)]

for i in range(K):
    a, b = map(int, input().split())
    graph[a - 1][b - 1] = 1

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y):
    global result
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N and graph[ny][nx]:
            graph[ny][nx] = 0
            result += 1
            dfs(nx, ny)


size = -1
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            graph[i][j] = 0
            result = 1
            dfs(i, j)
            size = max(result, size)
print(size)
# https://li-fo.tistory.com/66