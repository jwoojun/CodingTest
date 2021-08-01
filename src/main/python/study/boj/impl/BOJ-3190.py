import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
K = int(input())

board =[[0]*(N+1) for _ in range(N+1)]
info = []

for _ in range(K) :
    a, b = map(int, input().split())
    board[a][b] = 1


