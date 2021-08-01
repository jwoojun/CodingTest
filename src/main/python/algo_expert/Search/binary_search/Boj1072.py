import sys
from math import floor

input = sys.stdin.readline
X, Y = map(int, input().split())
Z = floor(100 * Y / X)

start, end = 0, 1000000000
ans = 0
if Z >= 99:
    print(-1)

else:
    while (start <= end):
        mid = (start + end) // 2

        if (floor(100 * (Y + mid) / (X + mid))) == Z:
            start = mid + 1
        else:
            end = mid - 1
            ans = int((int(Y + mid) / int(X + mid)) * 100)

    print(end + 1)
