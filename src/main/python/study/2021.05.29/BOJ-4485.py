import heapq
import sys

input = sys.stdin.readline

INF = sys.maxsize

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

count = 0


def dijkstra():
    q = []
    heapq.heappush(q, (graph[0][0], 0, 0))
    min_cost[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)
        if x == N - 1 and y == N - 1:
            print(f'Problem {count}: {min_cost[x][y]}')
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                new_cost = cost + graph[nx][ny]
                if new_cost < min_cost[nx][ny]:
                    min_cost[nx][ny] = new_cost
                    heapq.heappush(q, (new_cost, nx, ny))

while 1:
    N = int(input())
    if N == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(N)]
    min_cost = [[INF] * N for _ in range(N)]
    dijkstra()
    count += 1
# 3
# 5 5 4
# 3 9 1
# 3 2 7
# 0

