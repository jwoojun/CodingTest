N = int(input())

dp = [0] * 1000001
a = []
for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
        a.append("/2")
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)
        a.append("/3")
    # if i % 5 == 0:
    #     dp[i] = min(dp[i], dp[i // 5] + 1)
    #     a.append(dp[i])
print(a)
k  =list(set(a))
k.sort(reverse=True)

print(k, dp[N])
