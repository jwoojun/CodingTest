from collections import deque
import sys
input = sys.stdin.readline
N, M, K, X = map(int, input().split())
graph =[[] for _ in range(N+1)]
for i in range(M+1) :
    a, b = map(int, input().split())
    graph[a].append(b)

distance = [-1]*(N+1)
distance[X] = 0

q = deque([X])
while q :
    now = q.popleft()
    for next_node in graph[now] :
        if distance[next_node] == -1 :
            distance[next_node] = distance[now] +1
            q.append(distance[next_node])

flag = False
for i in range(1, N+1) :
    if distance[i] == K :
        print(i)
        chunk = True

if flag == False :
    print(-1)
