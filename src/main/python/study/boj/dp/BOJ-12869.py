N = int(input())
scv_life = list(map(int, input().split()))

dp = [[[-1] for _ in range(61) for _ in range(61) for _ in range(61)]]


