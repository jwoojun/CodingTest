import sys
from collections import deque
input = sys.stdin.readline


N, M = map(int, input().split())

board = []
red = []
blue = []
hole = []
visited = [[[[False]*M for i in range(N)] for i in range(M)] for i in range(N)]
for i in range(N) :
    board.append(list(map(str, input().rstrip())))
    for j in range(M) :
        if board[i][j] == "B" :
            blue.append((i,j))
        if board[i][j] == "R":
            red.append((i,j))
        if board[i][j] == 'O' :
            hole.append((i,j))




dx = [0,0,1,-1]
dy = [1,-1,0,0]



def visitable(x,y) :
    return 0<= x < N and 0<= y < M and board[x][y] == "."


def move(x, y, dx, dy) :
    count = 0
    while board[x][y] != 'O' and board[x+dx][y+dy] != '#' :
        x += dx
        y += dy
        count+=1
    return x, y, count


def bfs() :
    q = deque()
    q.append((red[0][0], red[0][1], blue[0][0], blue[0][1], 1))
    visited[red[0][0]][red[0][1]][blue[0][0]][blue[0][1]] = True
    # for i in range(len(visited)) :
    #     for j in range(len(visited[i])) :
    #         print(visited[i][j])
    # print("======================")
    while q :
        red_x, red_y, blue_x, blue_y, count = q.popleft()
        if count > 10 :
            break

        for i in range(4) :
            next_red_x, next_red_y, red_count = move(red_x, red_y, dx[i], dy[i])
            next_blue_x, next_blue_y, blue_count = move(blue_x, blue_y, dx[i], dy[i])
            if board[next_blue_x][next_blue_y] != 'O' :
                if board[next_red_x][next_red_y] == 'O' :
                    print(count)
                    return
                if next_red_x == next_blue_x and next_red_y == next_blue_y :
                    if red_count > blue_count :
                        next_red_x -= dx[i]
                        next_red_y -= dy[i]
                    else :
                        next_blue_x -= dx[i]
                        next_blue_y -= dy[i]

                if not visited[next_red_x][next_red_y][next_blue_x][next_blue_y] :
                    visited[next_red_x][next_red_y][next_blue_x][next_blue_y] = True
                    q.append([next_red_x,next_red_y,next_blue_x,next_blue_y, count+1])

    print(-1)
bfs()



