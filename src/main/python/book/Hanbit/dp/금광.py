import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

for i in range(N):
    n, m = map(int, input().split())
    mine = []
    lst = list(map(int, input().split()))
    for j in range(0, len(lst), m):
        mine.append(lst[j:j + m])
    dp_table = [[0] * m for _ in range(n)]
    for y in range(n):
        dp_table[y][0] = mine[y][0]
    for k in range(m):
        for p in range(1, n):
            now = mine[p][k]
            if p == 0:
                dp_table[p][k] = max(dp_table[p][k - 1] + now, dp_table[p + 1][k - 1] + now)
            elif p == n - 1:
                dp_table[p][k] = max(dp_table[p][k - 1] + now, dp_table[p - 1][k - 1] + now)
            else:
                dp_table[p][k] = max(dp_table[p][k - 1], dp_table[p - 1][k - 1], dp_table[p + 1][k - 1]) + now

    result = -1e9
    for z in dp_table:
        if max(z) > result:
            result = max(z)
    print(result)

# 1
# 3 4
# 1 3 3 2 2 1 4 1 0 6 4 7


# 2
# 3 4
# 1 3 3 2 2 1 4 1 0 6 4 7
# 4 4
# 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
