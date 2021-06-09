import sys

input = sys.stdin.readline

N, M = map(int, input().split())
visited = [False] * (N + 1)
graph = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1
answer = 0


def graph3(lst):
    for i in lst:
        print(i)


def dfs(start):
    global visited, graph
    visited[start] = True
    for j in range(1, N + 1):
        if graph[start][j] == 1:
            if not visited[j]:
                print(graph3(graph))
                print("--------------------------------------------------------")
                graph[start][j] = 0
                print(graph3(graph))
                print(visited)
                print("=========================================================")
                print("=========================================================", j)
                dfs(j)


for i in range(1, N + 1):
    if not visited[i]:
        dfs(i)
        answer += 1
print(answer)
