import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
dp_table = []
for i in range(n):
    dp_table.append(list(map(int, input().split())))


for i in range(1, n) :
    for j in range(i+1) :
        if j == 0 :
            up_left = 0
        else :
            up_left = dp_table[i-1][j-1]

        if j== len(dp_table[i])-1 :
            up = 0
        else :
            up = dp_table[i-1][j]

        dp_table[i][j] = dp_table[i][j] + max(up, up_left)

print(max(dp_table[n-1]))

