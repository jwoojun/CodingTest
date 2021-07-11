import sys
from collections import deque

input = sys.stdin.readline
N, M, K = map(int, input().split())
graph = [[0] * M for j in range(N)]

for i in range(K):
    x, y = map(int, input().split())
    graph[x - 1][y - 1] = 1

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(x, y, answer):
    q = deque()
    q.append((x, y))
    answer += 1
    graph[x][y] = 0

    while q:
        x_, y_ = q.popleft()
        for i in range(4):
            next_x = x_ + dx[i]
            next_y = y_ + dy[i]
            if 0 <= next_x < N and 0 <= next_y < M:
                if graph[next_x][next_y] == 1:
                    graph[next_x][next_y] = 0
                    answer += 1
                    q.append((next_x, next_y))

    return answer


max_ = -1e9
for i in range(N):
    answer = 0
    for j in range(M):
        if graph[i][j] == 1:
            max_ = max(bfs(i, j, answer), max_)

print(max_)
