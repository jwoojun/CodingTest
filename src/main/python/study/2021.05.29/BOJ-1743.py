# 음식물 피하기
import sys

sys.setrecursionlimit(100000)

input = sys.stdin.readline

N, M, K = map(int, input().split())
graph = [[0] * M for j in range(N)]
check = [[False] * M for j in range(N)]

for i in range(K):
    x, y = map(int, input().split())
    graph[x - 1][y - 1] = 1

def dfs(x, y, answer):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    graph[x][y] = 0
    answer +=1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if graph[nx][ny] == 1:
                dfs(nx, ny, answer)
    return answer


max_ = -1
for i in range(N):
    answer = 0
    for j in range(M):
        if graph[i][j] == 1:
            max_ = max(max_, dfs(i,j,answer))

# def bfs(x, y, answer) :
#     dx = [0, 0, 1, -1]
#     dy = [1, -1, 0, 0]
#     q = deque([[x,y]])
#     graph[x][y] = 0
#     answer += 1
#     while q :
#         a, b = q.popleft()
#         for i in range(4):
#             nx = a + dx[i]
#             ny = b + dy[i]
#             if 0 <= nx < N and 0 <= ny < M:
#                 if graph[nx][ny] == 1:
#                     answer += 1
#                     graph[nx][ny] = 0
#                     q.append([nx, ny])
#
#     return answer
# max_ = -1
# for i in range(N):
#     answer = 0
#     for j in range(M):
#         if graph[i][j] == 1:
#             max_ = max(max_, bfs(i,j,answer))

print(max_)

# https://li-fo.tistory.com/66
