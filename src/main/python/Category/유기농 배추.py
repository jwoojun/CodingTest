import sys

input = sys.stdin.readline


def dfs(x, y, grapph):

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                dfs(nx, ny, grapph)



T = int(input())
for i in range(T):
    answer = 0
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    for j in range(K):
        a, b = map(int, input().split())
        graph[b][a] = 1
    for i in range(N) :
        for j in range(M) :
            if graph[i][j] == 1 :
                    dfs(i, j, graph)
                    answer += 1

    print(answer)
