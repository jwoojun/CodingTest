import sys
input = sys.stdin.readline


T = int(input())
lst = [int(input()) for _ in range(T)]
memoi = [0]*1001
ans = []

memoi[0] = 1
memoi[1] = 1
memoi[2] = 2

for i in range(3, max(lst)+1) :
    if memoi[i] == 0 :
        memoi[i] = memoi[i-3] + memoi[i-2] + memoi[i-1]

for i in lst :
    print(memoi[i])


