import sys
from collections import deque
from bisect import bisect_left, bisect_right
# input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
# numbers.reverse()
dp_table = [1]*(N+1)
include =[numbers[0]]
max_value = numbers[0]
print(numbers)
print(include)
for i in numbers :
    add = bisect_left(include, i)
    if i < max_value :
        include.append(i)

    else :
        include[add-1]=i

print(include)

# for i in range(1, N) :
#     for j in range(0, i) :
#         if numbers[j] < numbers[i] :
#             dp_table[i] = max(dp_table[i], dp_table[j]+1)
#
# print(N-max(dp_table))
# 7
# 15 11 4 8 5 2 4