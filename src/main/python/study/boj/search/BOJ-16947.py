import sys
from collections import deque

input = sys.stdin.readline


def dfs(x, count):
    if check[x]:
        if count - distance[x] >= 3:
            return x

        else:
            return -1

    check[x] = 1
    distance[x] = count
    for y in adjust_list[x]:
        cycleStartNode = dfs(y, count + 1)
        if cycleStartNode != -1:
            check[x] = 2
            if x == cycleStartNode:
                return -1
            else:
                return cycleStartNode


N = int(input())
adjust_list = [[] * (N + 1) for _ in range(N + 1)]

check = [0] * (N + 1)
distance = [0] * (N + 1)

for _ in range(N):
    u, v = map(int, input().split())
    adjust_list[u].append(v)
    adjust_list[v].append(u)

# 사이클 탐색
dfs(1, 0)
q = deque([])

for i in range(1, N + 1):
    if check[i] == 2:
        q.append(i)
        distance[i] = 0
    else:
        distance[i] = -1

while q:
    x = q.popleft()
    for y in adjust_list[x]:
        if distance[y] == -1:
            q.append(y)
            distance[y] = distance[x] + 1

print(' '.join(map(str, distance[1:])))
