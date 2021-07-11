import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())

board=[]

coin_position = []
for i in range(N) :
    board.append(list(map(str, input().rstrip())))
    for j in range(M) :
        if board[i][j] == 'o' :
            coin_position.append([i,j])




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
