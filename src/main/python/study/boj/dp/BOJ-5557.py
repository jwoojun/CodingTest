# BOJ-5557(1학년)
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
dp_table = [[0 for _ in range(21) for _ in range(N + 1)]]
dp_table[1][numbers[0]] = 1
for i in range(1, N):
    for j in range(21):
        if dp_table[i][j] > 0:
            if 0 <= j - numbers[i] <= 20:
                dp[i + 1][j - numbers[i]] += dp[i][numbers[j]]

            if 0 <= j + numbers[i] <= 20:
                dp[i + 1][j + numbers[i]] += dp[i][numbers[j]]

print(dp_table[N - 1][numbers[N - 1]])

# dp_table = [[0 for _ in range(21)] for _ in range(N + 1)]
# dp_table[1][numbers[0]] = 1

# for i in range(1, N):
#     for j in range(21):
#         if dp_table[i][j] > 0:
#             if 0 <= j - numbers[i] <= 20:
#                 dp_table[i + 1][j - numbers[i]] += dp_table[i][j]
#             if 0 <= j + numbers[i] <= 20:
#                 dp_table[i + 1][j + numbers[i]] += dp_table[i][j]
#
# for i in dp_table:
#     print(i)
# print(dp_table[N - 1][numbers[N - 1]])

# https://rhdtka21.tistory.com/81
