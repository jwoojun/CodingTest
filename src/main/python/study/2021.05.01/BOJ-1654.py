import sys

input = sys.stdin.readline

N, K = map(int, input().split())
ropes = [int(sys.stdin.readline()) for _ in range(N)]
ropes.sort()

def binary_search(target, ropes):
    start = 1
    end = max(ropes)
    answer = 0
    while start <= end:
        mid = (start + end) // 2
        count = 0
        for rope in ropes:
            count += rope // mid
        if count >= target:
            answer = mid
            start = mid + 1
        else:
            end = mid - 1

    return answer
print(binary_search(K, ropes))
