import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

board_map = []
for i in range(1, N + 1):
    board_map.append(list(map(str, input().rstrip())))

# 보통 사람
visited = [[0] * N for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(a, b, type):
    q = deque()
    q.append((a, b, type))
    visited[a][b] = 1

    while q:
        x, y, type = q.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N:
                # 타입과 일치할 경우 탐색
                if board_map[next_x][next_y] == type:
                    if not visited[next_x][next_y]:
                        visited[next_x][next_y] = 1
                        q.append([next_x, next_y, type])
    return


count_normal = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j, board_map[i][j])
            count_normal += 1

special_count = 0
for i in range(N):
    for j in range(N):
        if board_map[i][j] == 'R':
            board_map[i][j] = 'G'

# 적록색약
visited = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j, board_map[i][j])
            special_count += 1

print(count_normal, special_count)
