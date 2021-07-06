import sys
from collections import deque

input = sys.stdin.readline

N, L, R = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]

united = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
sum_ = 0


def bfs(index, x, y):
    global united, sum_, count, data, dx, dy
    visited[x][y] = index
    q = deque()
    q.append((x, y))
    united.append((x, y))
    sum_ = data[0][0]
    count = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == -1:
                if L <= abs(data[nx][ny] - data[x][y]) <= R:
                    q.append((nx, ny))
                    visited[nx][ny] = index
                    sum_ += data[nx][ny]
                    count += 1
                    united.append((nx, ny))

    for i, j in united:
        data[i][j] = sum_ // count
    return count


total_count = 0

while True:
    index = 0
    visited = [[-1] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j] == -1:
                bfs(index, i, j)
                index +=1
                print(index)
    print(index)
    if index == N*N :
        break
    total_count += 1
print(total_count)