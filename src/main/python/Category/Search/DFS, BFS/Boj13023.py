import sys

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[] for _ in range(N)]
visited = [False for _ in range(N)]
for i in range(M) :
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(i, depth) :
    visited[i] = True
    print(visited, depth, graph)
    if depth == 4 :
        print(1)
        exit()
    for j in graph[i] :
        if not visited[j] :
            dfs(j, depth+1)
            visited[j] = False



for i in range(M) :
    print(i, visited)
    print("=======")
    dfs(i, 0)
    visited[i] = False

print(0)

# a = [[0] * 3] * 2
# print(a[0][0])
# print(a)
#
# b = [[False] for _ in range(4)]
# c = [[False] * 4]
# c[0] = True
#
# print(b)
# print(c)
