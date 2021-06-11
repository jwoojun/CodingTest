import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
dp = [[0, 0] for i in range(N)]
dp[0][0] = numbers[0]

m = -999999999
if N > 1 :
    for i in range(1, N):
        # 제거 안 하는 경우
        dp[i][0] = max(dp[i - 1][0] + numbers[i], numbers[i])

        # 제거 하는 경우
        dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + numbers[i])
        m = max(m, dp[i][0], dp[i][1])
    print(m)

else :
    print(dp[0][0])