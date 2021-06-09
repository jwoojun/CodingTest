N = 1260

# 동전 크기
coins = [10, 50, 100, 500]

# 개수
count = 0

coins.sort(reverse=True)

for i in coins :
    count += N//1260
    N %= i
print(count)