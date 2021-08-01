import sys
from collections import deque

input = sys.stdin.readline

T = int(input())


# def bfs(x, y):
#     dx = [0, 0, 1, -1]
#     dy = [1, -1, 0, 0]
#     graph[x][y] = 0
#     q = deque([[x, y]])
#     while q:
#         x, y = q.popleft()
#         for i in range(4) :
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0<= nx < N and 0<=ny < M :
#                 if graph[nx][ny] == 1 :
#                     graph[nx][ny] = 0
#                     q.append((nx,ny))
#
#
# for i in range(T):
#     M, N, K = map(int, input().split())
#     graph = [[0] * (M) for _ in range(N)]
#     for j in range(K):
#         x, y = map(int, input().split())
#         graph[y][x] = 1
#     answer = 0
#     for k in range(N):
#         for p in range(M):
#             if graph[k][p] == 1:
#                 bfs(k, p)
#                 answer += 1
#     print(answer)



def dfs(x, y):
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<= nx < N and 0<= ny < M :
            if graph[nx][ny] == 1 :
                graph[nx][ny] = 0
                dfs(nx, ny)


for i in range(T):
    M, N, K = map(int, input().split())
    ans = 0
    graph = [[0] * (M) for j in range(N)]
    for k in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1
    for i in range(N) :
        for j in range(M) :
            if graph[i][j] == 1 :
                dfs(i,j)
                ans += 1
    print(ans)
