import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = []
temp = [[0] * M for i in range(N)]

for i in range(N):
    graph.append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def speard_virus(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if temp[nx][ny] == 0:
                temp[nx][ny] = 2
                speard_virus(nx,ny)


def find_safezone():
    count = 0
    for i in range(N):
        for j in range(M):
            if temp[i][j] == 0:
                count += 1
    return count


def sync_map(graph1, graph2):
    for i in range(N):
        for j in range(M):
            graph1[i][j] = graph2[i][j]

result = 0
def dfs(count):
    global result
    if count == 3:
        sync_map(temp, graph)

        for i in range(N):
            for j in range(M):
                if temp[i][j] == 2 :
                    speard_virus(i, j)

        result = max(result, find_safezone())
        return

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                count += 1
                dfs(count)
                graph[i][j] = 0
                count -= 1

dfs(0)
print(result)