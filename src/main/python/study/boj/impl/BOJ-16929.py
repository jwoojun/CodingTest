import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
kind = set()
board = []
cycle = False
for i in range(N):
    board.append(list(map(str, input().rstrip())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y, current_X, current_Y, count, color):
    global cycle
    if cycle:
        return
    visited[current_X][current_Y] = True
    if x == current_X and y == current_Y and count >= 4:
        cycle = True
        return

    for i in range(4):
        next_x = current_X + dx[i]
        next_y = current_Y + dy[i]
        if 0 <= next_x < N and 0 <= next_y < M:
            if not visited[next_x][next_y] and color == board[next_x][next_y]:
                dfs(x, y, next_x, next_y, count + 1, color)

            elif next_x == x and next_y == y and count >= 4:
                dfs(x, y, next_x, next_y, count, color)
    return


for i in range(N):
    for j in range(M):
        visited = [[False] * M for _ in range(N)]
        dfs(i, j, i, j, 1, board[i][j])

if cycle:
    print("Yes")
    exit()
print("No")
