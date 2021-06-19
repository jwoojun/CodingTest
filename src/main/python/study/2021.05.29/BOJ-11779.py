# 최소 비용 구하기2
import copy
import sys
import heapq

input = sys.stdin.readline
INF = 1e9

n = int(input())
m = int(input())

graph = [[] for i in range(n + 1)]
path = [[] for j in range(n + 1)]
distance = [INF] * (n + 1)

for i in range(m):
    a, b, cost = map(int, input().split())
    graph[a].append((cost, b))


def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        now_cost, now_way = heapq.heappop(q)

        if distance[now_way] < now_cost:
            continue

        path[now_way].append(now_way)

        if now_way == end:
            return distance[now_way]

        for new_cost, new_way in graph[now_way]:
            if distance[new_way] > new_cost + now_cost:
                distance[new_way] = new_cost + now_cost
                heapq.heappush(q, (distance[new_way], new_way))
                path[new_way] = copy.deepcopy(path[now_way])


start, end = map(int, input().split())
print(dijkstra(start))
print(len(path[end]))
print(*path[end])
