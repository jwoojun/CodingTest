import sys

input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, x, y):
    a = find_parent(parent, x)
    b = find_parent(parent, y)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())
graph = [[] for _ in range(m + 1)]
parent = [0] * (n + 1)
for i in range(1, n + 1):
    parent[i] = i

for i in range(1, m + 2):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

a = set()

for i in range(1, len(parent)):
    a.add(parent[i])

ans = len(list(a))



if (len(ans)) == 1 :
    print("No trees.")
elif len(ans) == 2 :
    print("There is one tree.")
else :
    print("A forest of 3 trees.")
