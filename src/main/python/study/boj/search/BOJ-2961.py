import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

board = []

coin_position = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer = 0


# def dfs(x1, y1, x2, y2, count):
#     print(x1, y1, x2, y2, count)
#     if count >= 10:
#         return -1
#     for i in range(4):
#         next_x1 = x1 + dx[i]
#         next_y1 = y1 + dy[i]
#         next_x2 = x2 + dx[i]
#         next_y2 = y2 + dy[i]
#
#         if 0 <= next_x1 < N and 0 <= next_y1 < M and 0 <= next_x2 < N and 0 <= next_y2 < M:
#             temp_x1, temp_y1, temp_x2, temp_y2 = next_x1, next_y1, next_x2, next_y2
#             if board[next_x1][next_y1] == "#":
#                 temp_x1, temp_y1 = x1, y1
#             if board[next_x2][next_y2] == "#":
#                 temp_x2, temp_y2 = x2, y2
#             dfs(temp_x1, temp_y1, temp_x2, temp_y2, count + 1)
#
#         elif 0 <= next_x1 < N and 0 <= next_y1 < M:
#             return count + 1
#         elif 0 <= next_x2 < N and 0 <= next_y2 < M:
#             return count + 1
#
#     return -1


def bfs(a, b, c, d, count):
    q = deque()
    q.append((a, b, c, d, count))
    while q:
        x1, y1, x2, y2, cnt = q.popleft()
        if count >= 10:
            return -1
        for i in range(4):
            next_x1 = x1 + dx[i]
            next_y1 = y1 + dy[i]
            next_x2 = x2 + dx[i]
            next_y2 = y2 + dy[i]

            if 0 <= next_x1 < N and 0 <= next_y1 < M and 0 <= next_x2 < N and 0 <= next_y2 < M:
                if board[next_x1][next_y1] == "#":
                    next_x1, next_y1 = x1, y1
                if board[next_x2][next_y2] == "#":
                    next_x2, next_y2 = x2, y2
                q.append([next_x1, next_y1, next_x2, next_y2, cnt + 1])
                # print(q)
            elif 0 <= next_x1 < N and 0 <= next_y1 < M:
                return cnt + 1
            elif 0 <= next_x2 < N and 0 <= next_y2 < M:
                return cnt + 1

    return -1


for i in range(N):
    board.append(list(map(str, input().rstrip())))
    for j in range(M):
        if board[i][j] == 'o':
            coin_position.append([i, j])
for i in board:
    print(i)
x1, y1, x2, y2 = coin_position[0][0], coin_position[0][1], coin_position[1][0], coin_position[1][1]
answer = bfs(x1, y1, x2, y2, 0)
print(answer)
#
# bitter, sour = [], []
# for i in range(N):
#     b, s = map(int, input().split())
#     bitter.append(b)
#     sour.append(s)
#
# answer=[]
#
# def bfs(b_sum, s_sum, count):
#     global answer
#     q = deque()
#     q.append((b_sum, s_sum, count))
#
#     while q:
#         print(q, answer)
#         b, s, cnt = q.popleft()
#         if cnt == N:
#             continue
#         if cnt != 0 and b!= 1 or s!=0:
#             answer.append(abs(b - s))
#
#
#         else:
#             q.append((b, s, cnt+1))
#             q.append((b * bitter[count], s + sour[count], cnt + 1))
# bfs(1,0,0)
# print(answer)
# print(min(answer))

# N = int(input())
# dp_table = [0] * (N)
# if N <= 6:
#     print(N)
#     exit()
# for i in range(1, 7):
#     dp_table[i] = i
#
#
#
# # import sys
# # from collections import deque
# #
# # input = sys.stdin.readline
