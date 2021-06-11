N = int(input())
plan = list(input().split())

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 오른쪽, 왼쪽, 아래, 위
execution_plan = ["R", "L", "D", "N"]

# 시작
x, y = 1, 1

for i in plan:
    for j in range(len(execution_plan)):
        if i == execution_plan[j]:
            nx = x + dx[j]
            ny = y + dy[j]
            if 1 <= nx <= N and 1 <= ny <= N:
                x, y = nx, ny

print(x, y)