import sys

input = sys.stdin.readline
lst = [[0, 0]]
N, M = map(int, input().split())
for i in range(M):
    lst.append(list(map(int, input().split())))
memoi = [1] * (N + 1)
lst.sort()
for i in range(1, M + 1):
    if memoi[lst[i][1]] > memoi[lst[i][0]]:
        continue
    else:
        memoi[lst[i][1]] = memoi[lst[i][0]] + 1

print(memoi[1:])
