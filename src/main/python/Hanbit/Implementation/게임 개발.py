# 게임 개발
N, M = map(int, input().split())

d = [[0] for _ in range(N)]

x, y, direction = map(int, input().split())

# 현재 좌표를 방문 처리
d[x][y] = 1

# 지도 입력
array = []
for i in range(N):
    array.append(list(map(int, input().split())))

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
    return


count = 1
turn = 0
while 1:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 0
        x, y = nx, ny
        count += 1
        turn = 0
        continue
    else:
        turn += 1

    if turn == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]

        if array[nx][ny] == 0:
            x, y = nx, ny
        else:
            break
        turn = 0

print(count)
