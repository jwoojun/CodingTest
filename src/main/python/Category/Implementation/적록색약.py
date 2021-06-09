from collections import deque

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y) :
    queue.append([x, y])
    visited[x][y] = True
    print(visited)

    while queue :
        [x, y] = queue.popleft()
        # print(queue)

        # 이동한 수치만큼
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위를 벗어나지 않은 경우.
            if 0 <= nx < N and 0 <= ny < N :
                # 인접한 영역 & 방문하지 않은 경우.
                if grid[nx][ny] == grid[x][y] and visited[nx][ny] == False :
                    queue.append([nx, ny])
                    visited[nx][ny] = True
                    print(answer, (nx, ny), i)


N = int(input())
queue = deque()
grid = [list(map(str, input())) for _ in range(N)]
visited = [[False]*N for _ in range(N)]

answer = 0
for i in range(N) :
    for j in range(N) :
        if not visited[i][j] :
            bfs(i, j)
            answer += 1
            break
            print(answer, 'answer', (i, j))

for i in range(N) :
    for j in range(N) :
        if grid[i][j] == 'R' :
            grid[i][j] = 'G'

# print(visited)

visited = [[False]*N for _ in range(N)]
answer2 = 0
for i in range(N) :
    for j in range(N) :
        if not visited[i][j] :
            bfs(i, j)
            answer2 += 1
print(answer, answer2)