import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

# M의 개수
count = 0

# 증가시킬 포인터
end = 0

#부분 합
subSum = 0

for start in range(N):

    # 1. 선택
    while subSum < M and end < N:
        subSum += numbers[end]
        end += 1
    # 2. 비교
    if subSum == M:
        count += 1
    # 3. 제거
    subSum -= numbers[start]
print(count)
