# 게임개발
import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
x, y, direction = map(int, input().split())

board = []
visited = [[-1] * M for _ in range(N)]
for i in range(N):
    board.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            visited[i][j] = 1

# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def turn_direction():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3


board[x][y] = 1
count = 1
turn_time = 0
while 1:

    turn_direction()
    next_x = x + dx[direction]
    nexy_y = y + dy[direction]
    if visited[next_x][nexy_y] == -1 and board[next_x][nexy_y] == 0:
        visited[next_x][nexy_y] = 1
        x, y = next_x, nexy_y
        turn_time = 0
        count += 1
        continue
    else:
        turn_time += 1


    if turn_time == 4 :
        next_x = x - dx[direction]
        next_y = y - dy[direction]

        if board[next_x][next_y] == 0 :
            x, y = next_x, next_y

        else :
            break
        turn_time = 0
print(count)
