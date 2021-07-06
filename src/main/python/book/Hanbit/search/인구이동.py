import sys

input = sys.stdin.readline

N, L, R = map(int, input().split())
board = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(N):
    board.append(list(map(int, input().split())))

