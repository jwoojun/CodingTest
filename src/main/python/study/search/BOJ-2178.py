import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

board = []
distance = [[-1] * (M) for _ in range(N)]

for i in range(N):
    board.append(list(map(int, input().rstrip())))

distance[0][0] = 1

q = deque([(0, 0)])

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if board[nx][ny] == 1 and distance[nx][ny] == -1:
                distance[nx][ny] = distance[x][y] + 1
                q.append((nx, ny))

print(distance[N - 1][M - 1])
