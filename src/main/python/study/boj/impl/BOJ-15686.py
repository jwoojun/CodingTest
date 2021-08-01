import sys
from collections import deque
input = sys.stdin.readline


N, M = map(int, input().split())

board = []
for i in range(5) :
    board.append(list(map(int, input().split())))



