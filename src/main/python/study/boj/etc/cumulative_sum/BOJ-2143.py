import sys
from collections import defaultdict

input = sys.stdin.readline

T = int(input())
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

sum_A = defaultdict(int)
sum_B = defaultdict(int)

for i in range(N):
    for j in range(i, N):
        sum_A[sum(A[i:j+1])] += 1

for i in range(M):
    for j in range(i, M):
        sum_B[sum(B[i:j+1])] += 1
answer = 0

for key in sum_A.keys():
    answer += sum_B[T - key] * sum_A[key]
print(answer)