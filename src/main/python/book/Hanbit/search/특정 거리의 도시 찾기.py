import sys
from collections import deque
input = sys.stdin.readline

N, M, K, X = map(int, input().split())

cities_distance = [-1]*(N+1)
city_map = [[] for _ in range(N+1)]
for i in range(M) :
    A, B = map(int, input().split())
    city_map[A].append(B)


cities_distance[X] = 0
q= deque([])
q.append(X)
while q :
    now_city = q.popleft()
    for linked_city in city_map[now_city] :
        if cities_distance[linked_city] == - 1:
            cities_distance[linked_city] = cities_distance[now_city] + 1
            q.append(linked_city)

flag = False

for i in range(len(cities_distance)) :
    if cities_distance[i] == K :
        flag = True
        print(i)

if not flag :
    print(-1)