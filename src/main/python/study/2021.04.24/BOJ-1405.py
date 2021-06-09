# 미친 로봇
import sys

input = sys.stdin.readline

N, e, w, s, n = map(int, input().split())

def dfs(x, y, count, percent):

    global answer
    if count == N:
        answer += percent
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if coordinate[nx][ny]:
            continue
        if 0 <= nx < (2 * N) + 1 or 0 <= ny < (2 * N) + 1:
            coordinate[nx][ny] = 1
            dfs(nx, ny, count + 1, percent * direction_percentage[i] * 0.01)
            coordinate[nx][ny] = 0

# 좌표(coordinate)
coordinate = [[0] * (2 * N + 1) for _ in range(2 * N + 1)]
coordinate[N][N] = 1

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 각 방향으로 움직일 확률(동, 서, 남, 북)
direction_percentage = [e, w, s, n]

answer = 0
dfs(N, N, 0, 1)
print(answer)


