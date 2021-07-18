import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
T, P = [], []
for i in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

print(T)
print(P)
max_result = -1e9


def bfs(date, pay):
    global max_result
    q = deque()
    q.append((1, P[0]))

    while q:
        print('--------------------')
        print(q)

        total_date, total_pay = q.popleft()
        if total_date > 7 :
            continue
        if total_date <= 7 :
            q.append((total_date + T[total_date-1], total_pay + P[total_date-1+T[total_date-1]]))

            max_result = max(total_pay, max_result)


bfs(0, 0)
print(max_result)
