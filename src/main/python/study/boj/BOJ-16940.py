import sys
from collections import deque
input = sys.stdin.readline


N = int(input())
graph = [[] for _ in range(N+1)]
for _ in range(N-1) :
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1) :
    graph[i].sort()


answer = list(map(int, input().split()))
flag =False

visited = [False]*(N+1)
def bfs(N) :
    global flag
    q = deque()
    q.append(N)
    visited[N] = True
    start = 1
    temp=[]
    while q :
        lst = []
        for i in graph[q.popleft()] :
            if not visited[i] :
                visited[i] = True
                lst.append(i)
        newList = answer[start:start+len(lst)]
        temp = list(newList)
        start+= len(lst)
        newList.sort()
        if newList != lst :
            flag = True
            break
        else :
            for i in temp :
                q.append(i)

if answer[0] == 1 :
    bfs(1)
    print(1) if not flag else print(0)
    exit()
print(0)
print(0)
