import sys
from itertools import combinations

input = sys.stdin.readline

N, K = map(int, input().split())
lst = []
for i in range(N + 1):
    lst.append(i)



# 완전 탐색 -> 하다가 안되면 ~