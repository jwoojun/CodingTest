import sys
from collections import deque

input = sys.stdin.readline

# 공간의 넓이, 상어의 수, 이동 횟수
N, M, K = map(int, input().split())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

shark_position = []
shark_direction_map = []
each_shark_direction = [[] for _ in range(M)]

temp = [[0] * M for _ in range(N)]

for i in range(N):
    shark_position.append(list(map(int, input().split())))

current_position = list(map(int, input().split()))

for i in range(M):
    shark_direction_map.append(list(map(int, input().split())))

for i in shark_direction_map:
    print(i)

for i in each_shark_direction:
    print(i)


def spread_smell(x, y, shark_number):
    q = deque([x, y])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= y < N:
                if temp[nx][ny] == shark_number:
                    temp[nx][ny] = shark_number
                    q.append((nx, ny))


def dfs(count):
    if count == 0:
        return

    # for i in range(N) :
    #     for j in range(M) :
