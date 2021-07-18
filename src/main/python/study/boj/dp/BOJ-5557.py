# # BOJ-5557(1학년)
# import sys
# from collections import deque
#
# input = sys.stdin.readline
#
# N = int(input())
# numbers = list(map(int, input().split()))
# dp_table = [[0 for _ in range(21) for _ in range(N + 1)]]
# dp_table[1][numbers[0]] = 1
# for i in range(1, N):
#     for j in range(21):
#         if dp_table[i][j] > 0:
#             if 0 <= j - numbers[i] <= 20:
#                 dp[i + 1][j - numbers[i]] += dp[i][numbers[j]]
#
#             if 0 <= j + numbers[i] <= 20:
#                 dp[i + 1][j + numbers[i]] += dp[i][numbers[j]]
#
# print(dp_table[N - 1][numbers[N - 1]])
#
#
# def bfs():
#     answer = numbers[N - 1]
#     q = deque()
#     q.append(numbers[0])
#     temp = []
#     for i in range(1, N - 1):
#         value = numbers[i]
#         while q:
#             currnet_value = q.popleft()
#             if 0 <= currnet_value + value <= 20:
#                 temp.append(currnet_value + value)
#             if 0 <= currnet_value - value <= 20:
#                 temp.append(currnet_value - value)
#         q.extend(temp)
#
#     result = list(filter(lambda x: x == answer, q))
#     return len(result)
#
# # https://rhdtka21.tistory.com/81

numbers= [1,2,3,4]
answer= 3
result = list(filter(lambda x:x==answer, numbers))
print(result)
