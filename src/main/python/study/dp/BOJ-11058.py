from collections import deque
N = int(input())

dp_table = [0]*(N+1)

if N <= 6 :
    print(N)
    exit()

for i in range(1, 7) :
    dp_table[i] = i
for i in range(7, N+1) :
    for j in range(3, N+1) :
        dp_table[i] = max(dp_table[i-j]*(j-1), dp_table[i])

print(dp_table[N])
