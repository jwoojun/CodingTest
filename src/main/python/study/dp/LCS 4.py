import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

ansnerA = []
answerB = []

for i in A:
    position = bisect_left(ansnerA, i)
    if len(ansnerA) <= position:
        ansnerA.append(i)
    else:
        ansnerA[position] = i
for i in B:
    position = bisect_left(answerB, i)
    if len(answerB) <= position:
        answerB.append(i)
    else:
        # pass
        answerB[position] = i
print(len(answerB))
#

# 3
# 1 2 3
# 1 3 2
