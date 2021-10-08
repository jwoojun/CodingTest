import sys
from collections import deque
input = sys.stdin.readline

board = []
blank = []
for i in range(9) :
    board.append(list(map(int,input().split())))

def check_horizontal (x, value) :
    for number in range(9) :
        if value == board[x][number] :
            return False
    return True

# 저거를 한 번에 묶어서 풀어버린다.
def check_vertical(y, value) :
    for number in range(9) :
        if value == board[number][y] :
            return False
    return  True

for row in range(9) :
    for column in range(9) :
        if board[row][column] == 0 :
            blank.append([row,column])


def check_small_square(x, y, value):
    change_x = x // 3 * 3
    change_y = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if value == board[change_x + i][change_y + j]:
                return False
    return True


def dfs(index) :
    if index == len(blank) :
        for row in board :
            for column in row :
                print(column, end= " ")
            print()
        sys.exit(0)

    else :
        for i in range(1, 10) :
            x = blank[index][0]
            y = blank[index][1]
            if check_horizontal(x, i) and check_vertical(y, i) and check_small_square(x, y, i) :
                board[x][y] = i
                dfs(index+1)
                board[x][y]=0

dfs(0)