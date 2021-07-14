import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
board = []

for i in range(N):
    board.append(list(map(int, input().split())))
for i in board :
    print(i)

selected = [False] * N
answer= 1e9
def dfs(index, count) :
    global answer
    if count == N // 2 :
        start, link = 0, 0
        for i in range(N) :
            for j in range(N) :
                if selected[i] and selected[j] :
                    start += board[i][j]
                elif not selected[i] and not selected[j] :
                    link += board[i][j]

        answer = min(abs(start-link), answer)
        print(selected)

    for i in range(index, N) :
        if selected[i] :
            continue
        selected[i] =True
        dfs(i+1, count+1)
        selected[i] = False

dfs(0,0)
print(answer)