import sys
from collections import deque
import copy

input = sys.stdin.readline

numbers = list(map(int, input().split()))
board = [[0] * 8 for _ in range(6)]
temp_board = copy.deepcopy(board)
print(board)


# 10개 내외
def turn_left():
    for j in range(3):
        temp_board[2][j] = numbers[2][j + 2]


def turn_left2():
    return


def turn_right():
    return


def turn_right2():
    return


def turn_up():
    for j in range(3):
        temp_board[2][j] = numbers[2][j + 2]


def turn_up2():
    for j in range(3):
        temp_board[3][j] = numbers[3][j + 2]


def turn_down():
    for j in range(3):
        temp_board[2][j + 2] = numbers[2][j]


def turn_down2():
    for j in range(3):
        temp_board[3][j + 2] = numbers[3][j]

