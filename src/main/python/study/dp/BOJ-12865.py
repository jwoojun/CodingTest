import sys

input = sys.stdin.readline
from collections import deque

N, K = map(int, input().split())
value_weight = []

for i in range(N):
    value, weight = map(int, input().split())
    value_weight.append((value, weight))

value_sum = 0
weight_sum = 0
max_value = -1e9
count = 0

def dfs(weight_sum, value_sum, count):
    global max_value, value_weight
    if count > len(value_weight) :
        return

    if count ==len(value_weight) :
        if weight_sum <= K:
            max_value = max(max_value, value_sum)
            return max_value
    else:
        dfs(weight_sum + value_weight[count][0], value_sum + value_weight[count][1], count + 1)
        dfs(weight_sum, value_sum, count + 1)


def bfs(weight_sum,value_sum, count) :
    q = deque()
    q.append((weight_sum, value_sum, count))

    while q :
        if weight_sum > K or count > len(value_weight) :
            return

        if count == len(value_weight) :
            if weight_sum <= K :
                max_value = max(max_value, value_sum)
            return max_value

        else :
            q.append((weight_sum + value_weight[count][0], value_sum + value_weight[count][1], count + 1))
            q.append((weight_sum, value_sum, count + 1))

    return max_value
dfs(0, 0, 0)
print(max_value)
