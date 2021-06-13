import sys

input = sys.stdin.readline
N = int(input())
k = int(input())
# A = [[0] * (N + 1) for i in range(N + 1)]
# B = [0]

start, end = 0, k

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in range(1, N + 1):
        # 해당 숫자(mid)보다 작거나 같은 숫자들을 전부 찾아줌으로써 mid가 몇번째에 위치한 숫자인지 알아낼 수 있다.
        count += min(mid // i, N)
    if count >= k:
        answer = mid
        end = mid-1
    else:
        start = mid+1
print(answer)

# dp[i]= max(dp[i], dp[i-1]+1)

# 참조
# http://wookje.dance/2017/02/20/boj-1300-K%EB%B2%88%EC%A7%B8-%EC%88%98/
# https://claude-u.tistory.com/449