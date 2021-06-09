import math
import sys

input = sys.stdin.readline

n = int(input())
prime_numbers = [True] * (n + 1)
for i in range(2, int(math.sqrt(n) + 1)):
    j = 2
    while i * j <= n:
        prime_numbers[i * j] = False
        j += 1

numbers = []
for i in range(2, n + 1):
    if prime_numbers[i]:
        numbers.append(i)
answer = 0
# for i in range(len(numbers)) :
#     interval_num = 0
#     interval_num += numbers[i]
#     if interval_num == n :
#         answer += 1
#     for j in range(i+1, len(numbers)) :
#
#         interval_num += numbers[j]
#
#         if interval_num <= n :
#             if interval_num == n :
#                 answer +=1
#         else :
#             break
# print(answer)

start = 0
end = 0
interval_sum = 0

for start in range(len(numbers)):
    while interval_sum < n and end < len(numbers):
        interval_sum += numbers[end]
        end += 1

    if interval_sum == n:
        answer += 1

    interval_sum -= numbers[start]

print(answer)
