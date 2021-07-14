import sys

input = sys.stdin.readline

N, M, L = map(int, input().split())
station = list(map(int, input().split()))

station.append(0)
station.append(L - 1)
station.sort()
start, end = station[0], station[-1]
answer = 1e9
while start <= end:
    count = 0
    mid = (start + end) // 2
    for i in range(1, len(station)):
        distance = station[i] - station[i - 1]
        if distance > mid:
            count += (distance - 1) // mid
    if count > M:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1
print(answer)

# 이분 탐색의 정의
# https://velog.io/@psj8532/Algorithm-%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89