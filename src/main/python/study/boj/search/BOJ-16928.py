import sys

input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
ladder = []
snake = []
visited = [True] + [False] * (100)

# 사다리 좌표(출발점, 도착점)
for i in range(N):
    ladder.append(list(map(int, input().split())))

# 뱀 좌표(출발점, 도착점)
for i in range(M):
    snake.append(list(map(int, input().split())))

ladder.sort()
snake.sort()


# 뱀/사다리일 경우 이동
def ladder_or_snake(position):
    # 사다리 좌표 찾기
    for j in range(len(ladder)):
        if position == ladder[j][0]:
            return ladder[j][1]

    # 뱀 좌표 찾기
    for s in range(len(snake)):
        if position == snake[s][0]:
            return snake[s][1]

    # 뱀/사다리 좌표가 아니면 원래 좌표
    return position


def visitable(position) :
    return position <101 and not visited[position]


def bfs(position, count):
    q = deque()
    q.append((position, count))
    visited[position] = True

    while q:
        position, count = q.popleft()

        if position == 100:
            return count

        for i in range(1, 7):
            next_position = position + i
            if visitable(next_position) :
                new_position = ladder_or_snake(next_position)
                visited[new_position] = True
                q.append((new_position, count+1))

print(bfs(1, 0))



