import sys
from collections import deque
import copy
input = sys.stdin.readline

board = []
N, M = map(int, input().split())
for i in range(N):
    board.append(list(map(int, input().split())))

move = [(0, 1), (1, 0), (-1, 0), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1)]


def visitable(x, y):
    return 0 <= x < N and 0 <= y < M

# 반대로 있는 곳부터 접근하는 것 -> 먼저 들어간 것이 최솟값(벽을 부수거나) : 같은 레벨로 움직이니까
def bfs(i, j):
    q = deque()
    q.append((i, j, 0))
    visited[i][j] = 1
    while q:
        x, y, distance = q.popleft()
        # 가까운 곳 만나면 탐색 종료
        if board[x][y] == 1 :
            return distance

        for i in range(len(move)) :
            next_x = x + move[i][0]
            next_y = y + move[i][1]
            if visitable(next_x, next_y) and visited[next_x][next_y] != 1 :
                q.append((next_x, next_y, distance+1))
                visited[next_x][next_y] = 1
    return 0


result = 0
for row in range(N) :
    for column in range(M) :
        if board[row][column] != 1 :
            # 매번 새로운 방문 배열 생성
            visited = [[0]*M for _ in range(N)]
            count = bfs(row, column)
            result = max(count, result)

print(result)


