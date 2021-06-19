import math
import sys

input = sys.stdin.readline

n = int(input())
prime_numbers = [True] * (n + 1)
answer = 0
# 에르난데스의 체
for i in range(2, int(math.sqrt(n) + 1)):
    j = 2
    while i * j <= n:
        prime_numbers[i * j] = False
        j += 1

# 소수 판별 및 추가
# prime_numbers = [2,3, 5, 7, 11, 13 . . . ]
numbers = []
for i in range(2, n + 1):
    if prime_numbers[i]:
        numbers.append(i)

prime_number = numbers
count = 0
interval_sum = 0
end = 0

for start in range(len(prime_number)):
    while interval_sum < n and start < len(prime_number):
        interval_sum += prime_number[end]
        end += 1

    if interval_sum == n:
        count += 1

    interval_sum -= prime_number[start]

print(count)
