import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
dp_table = [0] * (N + 1)
T, P = [], []
for i in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

max_value = -1

for i in range(N - 1, -1, -1):
    time = T[i] + i
    if time <= N:
        dp_table[i] = max(max_value, P[i] + dp_table[time])
        max_value = dp_table[i]
    else:
        dp_table[i] = max_value
print(max_value)