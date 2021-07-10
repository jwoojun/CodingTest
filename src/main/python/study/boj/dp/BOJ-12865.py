import sys

input = sys.stdin.readline
N, K = map(int, input().split())


dp_table = [[0] * (K + 1) for _ in range(N + 1)]
bag = [[0, 0]]
for i in range(1, N + 1):
    bag.append(list(map(int, input().split())))

for i in range(1, N + 1):
    weight, value = bag[i][0], bag[i][1]
    for j in range(1, K + 1):
        if j < weight:
            dp_table[i][j] = dp_table[i - 1][j]
            continue

        dp_table[i][j] = max(dp_table[i - 1][j - weight] + value, dp_table[i - 1][j])
    # print('----------------------------')
    # for p in dp_table:
    #     print(p)
    # print('----------------------------')
print(dp_table[N][K])