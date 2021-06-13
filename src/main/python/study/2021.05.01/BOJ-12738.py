# 가장 긴 증가하는 부분 수열3
import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
answer = []
for i in numbers:
    position = bisect_left(answer, i)
    if len(answer) <= position:
        answer.append(i)
    else:
        answer[position] = i
        print(answer)
print(len(answer))





# 초기 실패했던 풀이
# import sys
#
# input = sys.stdin.readline
#
# N = int(input())
#
# numbers = [0] + list(map(int, input().split()))
#
# dp = [0] + [1] * (N)
#
# for i in range(1, N + 1):
#     for j in range(1, i):
#         if numbers[j] < numbers[i]:
#             dp[i] = max(dp[i], dp[j] + 1)
#
# print(max(dp))
