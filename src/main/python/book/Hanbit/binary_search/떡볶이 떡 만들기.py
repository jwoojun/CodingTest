# 떡볶이 떡 만들기
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
rice_cakes = list(map(int, input().split()))

rice_cakes.sort()


def binary_search(target, rice_cakes):
    start = 1
    end = rice_cakes[-1]
    answer = 0
    while start <= end:
        mid = (start + end) // 2
        length = 0
        for cake in rice_cakes:
            if cake > mid:
                length += (cake - mid)
                if length >= target:
                    answer = mid
                    start = mid + 1
                    break

        if length < target:
            end = mid - 1
    return answer


print(binary_search(M, rice_cakes))


# TestCase
# 4 6
# 19 15 17 10
