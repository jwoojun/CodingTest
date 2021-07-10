N = int(input())

dp_table = [0]*(N+1)
for i in range(1, 7) :
    dp_table[i] = i

# 6이하일 경우 그냥 출력하는 것이 더 크다.
if N <= 6 :
    print(dp_table[N])
    exit()

for i in range(7, N+1) :
    for j in range(3, N-1) :
        dp_table[i] = max(dp_table[i], dp_table[i-j]*(j-1))


print(dp_table[N])