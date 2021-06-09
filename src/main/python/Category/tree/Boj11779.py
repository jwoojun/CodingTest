import copy
import heapq
import sys



input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())
min_cost = [INF] * (m + 1)
graph = [[] for _ in range(m+1)]
path = [[] for _ in range(m+1)]
for i in range(m):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))

startPoint, endPoint = map(int, input().split())


def dijkstra(start):
    q = []
    min_cost[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        now_cost, now_way = heapq.heappop(q)

        if min_cost[now_way] < now_cost :
            continue

        path[now_way].append(now_way)
        for new_cost, new_way in graph[now_way] :
            if min_cost[new_way] > now_cost + new_cost :
                min_cost[new_way] = now_cost + new_cost
                heapq.heappush(q, (min_cost[new_way], new_way))
                path[new_way] = copy.deepcopy(path[now_way])