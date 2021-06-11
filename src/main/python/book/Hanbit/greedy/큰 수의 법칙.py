# 큰 수의 법칙(풀이1)
import sys
#
# input = sys.stdin.readline
#
# N, M, K = map(int, input().split())
# numbers = list(map(int, input().split()))
#
# numbers.sort()
#
# count = 0
# answer = 0
# for i in range(M):
#     count += 1
#     if count == K + 1:
#         answer += numbers[-2]
#         count = 0
#     else:
#         answer += numbers[-1]
# print(answer)



# 풀이2
input = sys.stdin.readline

N, M, K = map(int, input().split())
numbers = list(map(int, input().split()))

numbers.sort()


max_number_count = int(M/(K+1)) * K
max_number_count += M%(K+1)

answer = 0
answer += max_number_count * numbers[-1]
answer += (M-max_number_count)*numbers[-2]
print(answer)