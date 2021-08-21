import sys

input = sys.stdin.readline
N, M, K = map(int, input().split())

shark_position = []

for i in range(N):
    shark_position.append(list(map(int, input().split())))
directions = list(map(int, input().split()))

priorities = [[] for _ in range(M)]
for i in range(M):
    for j in range(4):
        priorities[i].append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
smell = [[[0, 0]] * N for _ in range(N)]

def update_smell() :
    for i in range(N):
        for j in range(N):
            if smell[i][j][1] > 0:
                print(smell[i][j][1])
                smell[i][j][1] -= 1

            if shark_position[i][j] != 0:
                smell[i][j] = [shark_position[i][j], K]
def move():
    new_shark_position = [[0] * N for _ in range(N)]
    for x in range(N):
        for y in range(N):
            if shark_position[x][y] != 0:
                direction = directions[shark_position[x][y] - 1]
                found = False
                for index in range(4):
                    next_x = x + dx[priorities[shark_position[x][y] - 1][direction - 1][index] - 1]
                    next_y = y + dy[priorities[shark_position[x][y] - 1][direction - 1][index] - 1]
                    if 0 <= next_x < N and 0 <= next_y < N:
                        if smell[next_x][next_y][1] == 0:
                            directions[shark_position[x][y] - 1] = priorities[shark_position[x][y] - 1][direction - 1][index]
                            if new_shark_position[next_x][next_y] == 0:
                                new_shark_position[next_x][next_y] = shark_position[x][y]
                            else:
                                new_shark_position[next_x][next_y] = min(new_shark_position[next_x][next_y],
                                        shark_position[x][y])
                            found = True
                            break
                if found:
                    continue

                for index in range(4):
                    next_x = x + dx[priorities[shark_position[x][y] - 1][direction - 1][index] - 1]
                    next_y = y + dy[priorities[shark_position[x][y] - 1][direction - 1][index] - 1]
                    if 0 <= next_x < N and 0 <= next_y < N:
                        if smell[next_x][next_y][0] == shark_position[x][y]:
                            directions[shark_position[x][y] - 1] = priorities[shark_position[x][y] - 1][direction - 1][index]
                            new_shark_position[next_x][next_y] = shark_position[x][y]
                            break

    return new_shark_position

time = 0
while True:
    update_smell()
    new_shark_position = move()
    shark_position = new_shark_position
    time += 1

    check = True
    for i in range(N):
        for j in range(N):
            if shark_position[i][j] > 1:
                check = False

    if check:
        print(time)
        break

    if time >= 1000:
        print(-1)
        break



# a1 -> 1
# a2 -> 1,1 / 2
# a3 -> 1,1,1 / 1,2 / 3
