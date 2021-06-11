import sys

input = sys.stdin.readline

N, M = map(int, input().split())
dp = [1e9] * (M + 1)
coins = [int(input()) for _ in range(N)]

dp[0] = 0

for i in range(N):
    for j in range(coins[i], M + 1):
        if dp[j - coins[i]] != 1e9:
            dp[j] = min(dp[j], dp[j - coins[i]] + 1)

if dp[M] != 1e9 :
    print(dp[M])
else :
    print(-1)
