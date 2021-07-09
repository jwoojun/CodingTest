import sys

input = sys.stdin.readline

N = int(input())

dp_table = [0] * N
dp_table[0] = 1

index_2 = index_3 = index_5 = 0
next2, next3, next5 = 2,3,5

for i in range(1, N) :
    dp_table[i] = min(next2, next3, next5)
    if dp_table[i] == next2 :
        index_2 += 1
        next2 = dp_table[index_2]*2
    if dp_table[i] == next3 :
        index_3 += 1
        next3 = dp_table[index_3]*3
    if dp_table[i] == next5 :
        index_5 += 1
        next5 = dp_table[index_5]*5
    print(dp_table)
print(dp_table[N-1])