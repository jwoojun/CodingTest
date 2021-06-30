from collections import deque
import copy

N = int(input())
indegree = [0] *(N+1)

graph = [[] for _ in range(N+1)]

time = [0]*(N+1)


for i in range(1, N+1) :
    data = list(map(int, input().split()))
    time[i] = data[0]
    for x in data[1:-1] :
        indegree[i] += 1
        print(data, i)
        graph[x].append(i)
        print(graph)
        print('----------------')

print(indegree)

# 테스트케이스
# 5
# 10 -1
# 10 1 -1
# 4 1 -1
# 4 3 1 -1
# 3 3 -1