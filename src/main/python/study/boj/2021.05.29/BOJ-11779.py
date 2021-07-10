# 최소 비용 구하기2
import copy
import sys
import heapq

input = sys.stdin.readline
INF = 1e9
n = int(input())
m = int(input())
graph = [[]  for i in range(n+1)]
path = [[]  for i in range(n+1)]
distance = [INF] * (n + 1)

for i in range(m):
    first, second, cost = map(int, input().split())
    graph[first].append([cost, second])


def dijkstra(start):
    global path
    q = []

    # 비용, 출발하는 도시
    heapq.heappush(q, (0, start))

    while q:
        now_cost, now_city = heapq.heappop(q)
        if distance[now_city] < now_cost:
            continue

        # 우선순위 힙에서 꺼낸 값을 추가
        path[now_city].append(now_city)

        if now_city == end:
            return distance[now_city]

        # 현재 도시와 이어진 곳 탐색
        for new_cost, new_city in graph[now_city]:
            cost = now_cost + new_cost

            # 새로운 도시에 방문했을 때의 비용이 최단거리테이블의 값보다 작을 경우 갱신
            if cost < distance[new_city] :
                distance[new_city] = cost
                heapq.heappush(q, (cost, new_city))

                # 새로운 도시에 방문하는 경로를 복사
                path[new_city] = copy.deepcopy(path[now_city])


start, end = map(int, input().split())

print(dijkstra(start))
print(len(path[end]))
print(*path[end])
