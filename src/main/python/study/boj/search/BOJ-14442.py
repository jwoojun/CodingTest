import sys
from collections import deque
input = sys.stdin.readline

N, M, K = map(int, input().split())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

board = []

for i in range(N) :
    board.append(list(map(int, input().rstrip())))
visited = [[[0]*(K+1) for _ in range(M)] for _ in range(N)]

def visitable(x, y, wall) :
    return 0<= x < N and 0<= y < M and not visited[x][y][wall]

def bfs() :
    q = deque()
    q.append((0,0,0))
    visited[0][0][0] = 1
    while q :
        x, y, wall = q.popleft()
        if x == N-1 and y == M-1 :
            return visited[N-1][M-1][wall]

        for i in range(4) :
            next_x = x + dx[i]
            next_y = y + dy[i]
            if visitable(next_x, next_y, wall) :
                if board[next_x][next_y] == 0 :
                    visited[next_x][next_y][wall] = visited[x][y][wall]+1
                    q.append((next_x, next_y, wall))
                elif board[next_x][next_y] == 1 and wall+1 <= K :
                    visited[next_x][next_y][wall+1] = visited[x][y][wall]+1
                    q.append((next_x, next_y, wall+1))
    return -1
print(bfs())