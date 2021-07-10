import sys

input = sys.stdin.readline

N = int(input())
select = [False for _ in range(N)]
board = [list(map(int, input().split())) for _ in range(N)]
answer = 1e9


def dfs(index, count):
    global answer
    if count == N // 2:
        start, link = 0, 0
        for i in range(N):
            for j in range(N):
                if select[i] and select[j]:
                    start += board[i][j]
                elif not select[i] and not select[j]:
                    link += board[i][j]

        answer = min(answer, abs(start - link))

    for i in range(index, N):
        if select[i]:
            continue
        select[i] = True
        dfs(i + 1, count + 1)
        select[i] = False


dfs(0, 0)
print(answer)
