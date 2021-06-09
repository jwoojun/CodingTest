# 1092
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
cranes = list(map(int, input().split()))
M = int(input())
weights = list(map(int, input().split()))

cranes.sort(reverse=True)
weights.sort(reverse=True)
deque = deque(weights)

result = []
count = 0
answer = 0
switch = False
if cranes[0] < weights[0]:
    print(-1)
else:
    # ㅋ
    while (len(deque) != 0):
        for i in cranes:
            for j in deque:
                if j <= i:
                    result.append(deque.popleft())
                    # switch = True
                    count += 1
                    break
            # if switch :
            #     switch = False
            #     break
        if count == len(cranes):
            answer += 1
            count = 0
        #  6 10
        #  9
        if len(deque) == 0:
            answer += 1
            print(answer)
            break
