import sys
from collections import deque
input = sys.stdin.readline

lst = []
N, K = map(int,input().split())
for i in range(N) :
    lst.append(int(input()))

dp_table = [0]*10001
for i in range(len(lst)) :
    for j in range(dp_table[i], K+1) :
        dp_table[j] = min(dp_table[j], dp_table[j-dp_table[i]])+1

print(dp_table[K])