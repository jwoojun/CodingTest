def dfs(x, y, n, computers):
    computers[x][y] = 0
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if (0 <= nx < n and 0 <= ny < n):
            x, y= nx, ny
            if computers[nx][ny] == 1:
                computers[nx][ny] = 0
                dfs(nx, ny, n, computers)

def solution(n, computers):
    answer = 0
    for i in range(n) :
        for j in range(n) :
            if computers[i][j] == 1 :
                dfs(i, j, n, computers)
                answer += 1
    dfs(0, 0, n, computers)
    return answer

# def dfs(x, y, n, computers):
#     dx = [0, 0, 1, -1]
#     dy = [1, -1, 0, 0]
#     for i in range(n):
#             if computers[x][i] == 1:
#                 computers[x][i] = 0
#                 dfs(i, x, n, computers)
computers= [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
n = 3

# def solution(n, computers):
#     answer = 0
#     for i in range(n):
#         for j in range(n):
#             if computers[i][j] == 1:
#                 dfs(i, j, n, computers)
#                 answer += 1
#     dfs(0, 0, n, computers)
#     return answer
print(solution(n, computers))
# n = 3
# answer = 0
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]
# x, y  = 0, 0
# computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
# for i in range(n):
#     for i in range(4):
#         nx = dx[i] + x
#         ny = dy[i] + y
#
#         if (0 <= nx < n and 0 <= ny < n):
#             x, y = nx, ny
#             if computers[nx][ny] == 1 and nx != ny:
#                 answer += 1
#
# print(answer)
