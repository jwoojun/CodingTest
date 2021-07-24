import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
dp_table = [0]*(N+1)
T, P = [], []
for i in range(N) :
    t, p = map(int,input().split())
    T.append(t)
    P.append(p)

max_value = 0
for i in range(N-1, -1, -1) :
    time = T[i] + i
    if time <= N :
        dp_table[i] = max(P[i]+dp_table[time], max_value)
        max_value = dp_table[i]

    else:
        dp_table[i]=max_value

print(max_value)



# T, P = [], []
# for i in range(N) :
#     t, p = map(int,input().split())
#     T.append(t)
#     P.append(p)
# max_value = 0
# for i in range(N-1, -1, -1) :
#     time = T[i] + i
#     if time <= N :
#         dp_table[i] = max(P[i]+dp_table[time], max_value)
#         max_value = dp_table[i]
#
#     else :
#         dp_table[i] = max_value

print(max_value)




# from math import factorial
#
# def catalan(num):
#     return factorial(2 * num) // (factorial(num) * factorial(num + 1))
#
# print(catalan(4))