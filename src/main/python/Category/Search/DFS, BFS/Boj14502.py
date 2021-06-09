import sys

input = sys.stdin.readline

N, M = map(int, input().split())

graph = []
map_ = [[0] * M for _ in range(N)]

for i in range(N):
    graph.append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer = 0


def virus(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < N and ny >= 0 and ny < M:
            if map_[nx][ny] == 0:
                map_[nx][ny] = 2
                virus(nx, ny)


def safety():
    count = 0
    for i in range(N):
        for j in range(M):
            if map_[i][j] == 0:
                count += 1
    return count


def dfs(count):
    global answer
    if count == 3:
        for i in range(N):
            for j in range(M):
                map_[i][j] = graph[i][j]

        for i in range(N):
            for j in range(M):
                if map_[i][j] == 2:
                    virus(i, j)
        answer = max(answer, safety())
        return

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                count += 1
                dfs(count)
                graph[i][j] = 0
                count -= 1


dfs(0)
print(answer)
