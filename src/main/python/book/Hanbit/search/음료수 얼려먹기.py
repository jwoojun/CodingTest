import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int,input().split())

board = []
for i in range(N) :
    board.append(list(map(int,input().split())))

visited = [[False]*M for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]
for k in board :
    print(k)
    
print('----------------')
def bfs(i, j) :
    q = deque()
    q.append((i,j))
    while q :
        x, y = q.popleft()
        for i in range(4) :
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0<= next_x < N and 0<=next_y < M :
                if board[next_x][next_y] == 0 :
                    board[next_x][next_y]= 1
                    q.append((next_x, next_y))
                    for k in board :
                        print(k)
                    print('----------------------------')

answer = 0
for i in range(N) :
    for j in range(M) :
        if board[i][j] == 0  :
            board[i][j]=1
            bfs(i,j)
            answer += 1

# 4 5
# 0 0 1 1 0
# 0 0 0 1 1
# 1 1 1 1 1
# 0 0 0 0 0

print(answer)
