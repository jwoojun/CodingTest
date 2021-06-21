# 부분합
import sys

input = sys.stdin.readline
N, S = map(int, input().split())
numbers = list(map(int, input().split()))
min_length = 1e9

def two_pointer(numbers, target):
    global min_length
    start = end = 0
    sum_ = 0

    while 1:
        if sum_ < target:
            sum_ += numbers[end]
            end += 1

        if sum_ >= target:
            min_length = min(min_length, (end - start))
            sum_ -= numbers[start]
            start += 1

        if end == len(numbers) :
            break
        print(start, end, sum_, min_length)
    return min_length


if two_pointer(numbers, S) == 1e9 :
    print(0)
    exit()

print(two_pointer(numbers, S))




# # 부분합
# import sys
#
# input = sys.stdin.readline
# N, S = map(int, input().split())
# numbers = list(map(int, input().split()))
# min_length = 1e9
#
# def two_pointer(numbers, target):
#     global min_length
#     start = end = 0
#     sum_ = 0
#
#     while 1:
#         if sum_ >= target:
#             min_length = min(min_length, (end - start))
#             sum_ -= numbers[start]
#             start += 1
#         elif end == len(numbers) :
#             break
#         else :
#             sum_ += numbers[end]
#             end += 1
#
#     return min_length
#
#
# if two_pointer(numbers, S) == 1e9 :
#     print(0)
#     exit()
#
# print(two_pointer(numbers, S))
