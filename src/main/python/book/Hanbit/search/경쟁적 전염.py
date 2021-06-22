import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

# 실제 바이러스가 퍼진 위치
board = []

# 바이러스의 정보를 담을 리스트
data = []

for i in range(N) :
    board.append(list(map(int, input().split())))

    # 바이러스의 번호가 낮을 수록 먼저 전염되기 때문에 바이러스 순으로 정렬
    for j in range(N) :

        # 바이러스가 존재한다면 (바이러스, 시간, i좌표, j좌표) 저장
        if board[i][j] == 0 :
            data.append((board[i][j], 0, i, j))


data.sort()
q = deque(data)

print('\n', data)
S, X, Y = map(int,input().split())

dx = [0,0,1,-1]
dy = [1,-1,0,0]

while q :
    virus, time, x, y = q.popleft()

    # 특정 시간이 흐른 후 종료
    if time == S :
        break
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<= nx < N  and 0<= ny<N :
            if board[nx][ny] == 0 :
                board[nx][ny] = virus
                q.append((virus, time+1, x, y))

print(board[x-1][y-1])