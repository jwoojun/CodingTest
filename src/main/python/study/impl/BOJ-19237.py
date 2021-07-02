N, M, K = map(int, input().split())

array = []
for i in range(N):
    array.append(list(map(int, input().split())))

directions = list(map(int, input().split()))

smell = [[[0, 0]] for _ in range(N)]

priorities = [[] * (M)]
for i in range(M):
    for j in range(4):
        priorities[i].append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def update_smell():
    for i in range(N):
        for j in range(N):
            if smell[i][j][1] > 0:
                smell[i][j][1] -= 1

            if array[i][j] != 0:
                smell[i][j] = [array[i][j], k]
                
