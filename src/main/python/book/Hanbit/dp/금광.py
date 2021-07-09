import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
n, m = map(int, input().split())
board = []
numbers = list(map(int, input().split()))
dp = []
for i in range(0, len(numbers), m):
    dp.append(numbers[i:i + 4])

for j in range(1, m):
    for i in range(n):
        if i == 0:
            left_up = 0
        else:
            left_up = dp[i - 1][j - 1]
        if i == n - 1:
            left_down = 0
        else:
            left_down = dp[i + 1][j - 1]
        left = dp[i][j - 1]
        print(left_down, left, left_up)
        dp[i][j] = dp[i][j] + max(left_down, left, left_up)
result = 0
for i in range(n):
    result = max(result, dp[i][m - 1])
print(result)

# 1
# 3 4
# 1 3 3 2 2 1 4 1 0 6 4 7
