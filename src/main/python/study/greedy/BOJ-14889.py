import sys

input = sys.stdin.readline

N = int(input())
board = []
subSum = []

for i in range(N):
    board.append(list(map(int, input().split())))


def sum_elements():
    for i in range(N):
        for j in range(N):
            sum_ = board[i][j] + board[j][i]
            if sum_ not in subSum:
                subSum.append(sum_)


min_ = 1e9


def bfs():
    if count == 2 / N - 1:
