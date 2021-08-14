import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())
board = []
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]
for i in range(N) :
    board.append(list(map(int,input().rstrip())))

dx = [0,0,1,-1]
dy = [1,-1, 0,0]

def visitable(x, y,z) :
    return 0<= x < N and 0<= y < M and visited[x][y][z] == 0
def bfs() :
    q = deque()
    q.append((0,0, 0))
    visited[0][0][0] = 1
    while q :
        x, y, block = q.popleft()

        if x == N-1 and y == M-1 :
            return visited[x][y][block]
        for i in range(4) :
            next_x = x + dx[i]
            next_y = y + dy[i]
            if visitable(next_x, next_y, block) :
                if board[next_x][next_y] == 1 and block == 0:
                    visited[next_x][next_y][1] = visited[x][y][0]+1
                    q.append((next_x, next_y, 1))
                elif board[next_x][next_y] == 0 :
                    visited[next_x][next_y][block] = visited[x][y][block]+1
                    q.append((next_x, next_y, block))

    return -1
print(bfs())

