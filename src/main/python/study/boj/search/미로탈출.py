import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(x, y):
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if (nx <0 or ny<0 or nx >= N or ny >= M) :
                continue

            if graph[nx][ny] == 0 :
                continue

            if graph[nx][ny] == 1 :
                graph[nx][ny] = graph[x][y] +1
                q.append((nx, ny))

    return graph[N-1][M-1]

print(bfs(0,0))


# input = sys.stdin.readline
#
# N, M = map(int, input().split())
# board = []
# for i in range(N):
#     board.append(list(map(int, input().split())))
#
# cost = copy.deepcopy(board)
# dx= [0,0,1,-1]
# dy=[1,-1,0,0]
#
# def bfs(i,j ) :
#     board[i][j] = 1
#     q = deque()
#     q.append((i,j))
#
#     while q :
#         x, y = q.popleft()
#         for i in range(4) :
#             next_x = x + dx[i]
#             next_y = y + dy[i]
#             if 0<= next_x<N and 0<= next_y <M :
#                 if cost[next_x][next_y] == 1 :
#                     cost[next_x][next_y] = cost[x][y] +1
#                     q.append((next_x,next_y))
#
#     return cost[N-1][M-1]
#
# print(bfs(0,0))
# 5 6
# 1 0 1 0 1 0
# 1 1 1 1 1 1
# 0 0 0 0 0 1
# 1 1 1 1 1 1
# 1 1 1 1 1 1