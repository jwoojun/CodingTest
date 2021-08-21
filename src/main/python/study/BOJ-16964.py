import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
lst = []
for i in range(N-1) :
    lst.append(list(map(int,input().split())))

order= list(map(int, input().split()))
print(order)

