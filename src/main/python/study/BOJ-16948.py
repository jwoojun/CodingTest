import sys
from collections import deque
input = sys.stdin.readline


n = map(int ,input())


move = [(-2, -1), (-2, 1), (0, -2), (0, 2), (2,-1), (2, 1)]
N = int(input())
visited = [[0]*(N) for _ in range(N)]
x, y, result_x, result_y = map(int,input().split())

def visitable(x, y) :
    return 0<= x < N and 0<= y < N and visited[x][y] == 0

def bfs(a, b) :
    global result_x, result_y
    q = deque()
    q.append([a,b, 0])
    visited[a][b] = 1
    while q :
        x, y, count = q.popleft()
        if x == result_x and y == result_y :
            return count
        for number in range(len(move)) :
            next_x = x + move[number][0]
            next_y = y + move[number][1]
            if visitable(next_x, next_y) :
                q.append((next_x, next_y, count+1))
                visited[next_x][next_y] = 1

    return -1
print(bfs(x, y))