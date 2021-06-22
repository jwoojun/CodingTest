import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(M + 1)]
distance = [-1] * (N + 1)

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
distance = [-1] * (N + 1)
distance[X] = 0

q = deque([X])
while q:
    now = q.popleft()

    # 현재 도시와 연결된 도시 중
    for next_node in graph[now]:

        # 아직 방문하지 않았을 경우
        if distance[next_node] == -1:

            # 해당 도시를 방문
            distance[next_node] = distance[now] + 1
            q.append(next_node)

check = False
for i in range(1, N+1) :
    if distance[i] == K :
        print(i)
        check= True

if check == False :
    print(-1)
