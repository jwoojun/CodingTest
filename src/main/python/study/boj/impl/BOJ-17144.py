

import sys
from collections import deque
input = sys.stdin.readline

R, C, T = map(int, input().split())

board = []
for i in range(R) :
    board.append(list(map(int, input().split())))
dx = [0,0,1, -1]
dy = [1,-1,0,0]


temp = [[0]*C for _ in range(R)]

# 청소기 -> 범위가 가능한 것만 따로 빼기
def spread_all_direction(k, z) :
    lst = []
    if 0 <= k + 1 < R and 0 <= z < C:
        lst.append([k+1, z])
    if 0 <= k - 1 < R and 0 <= z < C:
        lst.append([k-1, z])
    if 0 <= k < R and 0 <= z - 1 < C:
        lst.append([k, z-1])
    if 0 <= k < R and 0 <= z + 1 < C:
        lst.append([k, z+1])
    return lst



def spread_dust(x,y) :
    able_lst = spread_all_direction(x, y)
    for albe_x, albe_y in able_lst:
        temp[albe_x][albe_y] += board[x][y] // 5
    # tem = board[x][y]-board[x][y] // 5 * len(able_lst)
    temp[x][y] += board[x][y]-board[x][y] // 5 * len(able_lst)
    return

cleaner = []

for i in range(R) :
    for j in range(C) :
        if board[i][j] == -1 :
            cleaner.append([i,j])
        if board[i][j] >0 :
            spread_dust(i, j)

for i in range(len(cleaner)) :
    x, y = cleaner[i]
    temp[x][y] = -1
for i in temp :
    print(i)


answer = 0
for i in range(R) :
    for j in range(C) :
            answer += temp[i][j]
print(answer+2)


def find_cleaner_position(x,y) :
    lst = []
    while y < C :
        if temp[x][y] != 0 :
            lst.append((x,y, temp[x][y]))


# 배열 돌리기

# 한 번에 처리

# 최대한 심플하게
