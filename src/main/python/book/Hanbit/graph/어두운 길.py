N, M = map(int,input().split())
def find_parent(parent, x) :
    if parent[x] != x :
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

parent =[0]*(N+1)
for i in range(N+1) :
    parent[i] = i
