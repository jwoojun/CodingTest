import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
board = []
data = []
for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(N):
        if board[i][j] != 0:
            data.append((board[i][j], 0, i, j))

S, X, Y = map(int, input().split())
data.sort()
q = deque(data)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
while q:
    virus, time, x, y = q.popleft()
    if time == S:
        break
    for i in range(4):
        next_x = x + dx[i]
        nexy_y = y + dy[i]
        if 0<= next_x < N and 0<= nexy_y < N :
            if board[next_x][nexy_y] == 0 :
                board[next_x][nexy_y] = virus
                q.append((virus,time+1, next_x, nexy_y))

print(board[X-1][Y-1])