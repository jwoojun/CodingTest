import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(coin):
    while coin:
        x1, y1, x2, y2, count = coin.popleft()

        if count >= 10:
            return -1

        for i in range(4):
            next_x1 = x1 + dx[i]
            next_y1 = y1 + dy[i]
            next_x2 = x2 + dx[i]
            next_y2 = y2 + dy[i]

            if 0 <= next_x1 < N and 0 <= next_x2 < N and 0 <= next_y1 < M and 0 <= next_y2 < M:
                if board[next_x1][next_y1] == "#":
                    next_x1, next_y1 = x1, y1

                if board[next_x2][next_y2] == "#":
                    next_x2, next_y2 = x2, y2

                coin.append([next_x1, next_y1, next_x2, next_y2, count + 1])

            elif 0 <= next_x1 < N and 0 <= next_y1 < M:
                return count + 1

            elif 0 <= next_x2 < N and 0 <= next_y2 < M:
                return count + 1

            else:
                continue
    return -1


board = []
coin = deque()
temp = []

for i in range(N):
    board.append(list(map(str, input().rstrip())))
    for j in range(M):
        if board[i][j] == 'o':
            temp.append([i, j])

coin.append([temp[0][0], temp[0][1], temp[1][0], temp[1][1], 0])

print(bfs(coin))
