import sys
from collections import deque
input = sys.stdin.readline

move = [(-2, -1), (-2,1), (0, -2), (0, 2), (2,-1), (2,1)]

N = int(input())
x1, y1, x2, y2 = map(int,input().split())
visited =[[0]*N for _ in range(N)]


def visitable(x, y) :
    return 0<= x < N and 0<=y <N and not visited[x][y]

def bfs(a, b) :
    global x1, y1, x2, y2
    q = deque()
    q.append((a,b, 0))
    visited[a][b] = 1
    while q :
        x, y, count = q.popleft()
        if x == x2 and y == y2 :
            return count
        for i in range(6) :
            next_x = x + move[i][0]
            next_y = y + move[i][1]
            if visitable(next_x, next_y) :
                visited[next_x][next_y]=True
                q.append((next_x, next_y, count+1))
    return -1
print(bfs(x1,y1))