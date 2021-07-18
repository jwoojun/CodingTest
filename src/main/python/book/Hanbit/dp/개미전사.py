import sys
from collections import deque

input = sys.stdin.readline


N = int(input())
food = [0]+list(map(int,input().split()))
dp_table = [0]*(N+1)
dp_table[1] = food[1]
dp_table[2]=food[2]

for i in range(2,N+1) :
    dp_table[i] = max(dp_table[i-2]+food[i], dp_table[i-1] )

print(dp_table[N])
