import sys
input = sys.stdin.readline
board = []
teacheers = []
spaces = []
N = int(input())
for i in range(N) :
    board.append(list(input().split()))
    for j in range(N) :
        if board[i][j] == 'T' :
            teacheers.append((i,j))
        if board[i][j] == 'X' :
            spaces.append((i,j))

def watch(x, y, direction) :
    if direction == 0 :
        while y >= 0 :
            if board[x][y] == 'S' :
                return True
            if board[x][y] == 'O' :
                return False

            y -= 1

    if direction == 1 :
        while y < N :
            if board[x][y] == 'S' :
                return True
            if board[x][y] == 'O' :
                return False

            y += 1

    if direction == 2 :
        while x >= 0 :
            if board[x][y] == 'S' :
                return True
            if board[x][y] == 'O' :
                return False

            x -= 1

    if direction == 1 :
        while x < N :
            if board[x][y] == 'S' :
                return True
            if board[x][y] == 'O' :
                return False

            x += 1
    return False