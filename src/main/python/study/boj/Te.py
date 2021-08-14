import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
lst = []
memoi = [0]*(10000)
memoi[2] = 2
memoi[3] = 2

def makeMemoi() :
    for i in range(4,9999) :
        memoi[i] = memoi[i-1]+2

makeMemoi()
print(memoi[:10])
for i in range(N) :
    number = int(input())
    print(memoi(number))








