import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
dp_table = [[0, 0] for _ in range(N)]
dp_table[0][0] = numbers[0]
max_value = -1e9
for i in range(1, N):
    dp_table[i][0] = max(numbers[i], dp_table[i - 1][0] + numbers[i])
    dp_table[i][1] = max(dp_table[i - 1][1] + numbers[i], dp_table[i - 1][0])
    print("dp_table[i][0]= ",dp_table[i][0], "dp_table[i][1]= ",dp_table[i][1], "max_value= ",max_value)
    max_value = max(dp_table[i][0], dp_table[i][1], max_value)
print(max_value)
