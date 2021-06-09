import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

parent = [0] * (N + 1)

for i in range(1, N + 1):
    parent[i] = i


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)

    if a == b:
        return
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


graph = [0 * (N + 1)]

for i in range(1, N + 1):
    graph.append([0]+list(map(int, input().split())))
    # 조금 더 직관적으로 보기 위해 list 앞에 0 추가
    #    0 0 1 0
    #    0 1 0 1
    #    0 0 1 0

travel_plan = list(map(int, input().split()))

for x in range(1, N + 1):
    for y in range(1, N + 1):
        if graph[x][y] == 1:
            union_parent(parent, x, y)

    # graph[x][y] == 1 일 경우 유니온 파인드로 부모를 합침
    # test_case
    # [0, 1, 1, 1]


answer = set([find_parent(parent, i) for i in travel_plan])
    # 부모의 주소를 기준으로 travel_plan 검토
    # travel_plan이 모두 이어져 있을 경우 여행가능. 아니면 불가능.

if len(answer) >1 :
    print("NO")
else :
    print("YES")
