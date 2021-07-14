# 가장 긴 증가하는 부분 수열3
import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
ans = []
for i in numbers:
    position = bisect_left(ans, i)
    if len(ans) <= position:
        ans.append(i)
    else:
        ans[position] = i
print(len(ans))
# https://namu.wiki/w/%EC%B5%9C%EC%9E%A5%20%EC%A6%9D%EA%B0%80%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4#s-3.2