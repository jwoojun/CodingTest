import sys

input = sys.stdin.readline
N, K = map(int, input().split())


# 잘못된 풀이(1)
dp_table = [[0] * (K + 1) for _ in range(N + 1)]
bag = [[0, 0]]
for i in range(N) :
    bag.append(list(map(int, input().split())))
dp =[0]*(N+1)
for i in range(1, N+1) :
    dp[i] = 0

for i in range(1, N+1) :
    weight, value = bag[i][0], bag[i][1]
    for j in range(1, K+1) :
        if j >= weight :
            dp_table[i][j] = max(dp_table[i - 1][j - weight] + value, dp_table[i - 1][j])
print(dp_table[N][K])



# 올바른 풀이


#
# dp_table = [[0]*(K+1) for _ in range(N+1)]
# bag = [(0,0)]



# dp_table = [[0] * (K + 1) for _ in range(N + 1)]
# bag = [[0, 0]]
# for i in range(1, N + 1):
#     bag.append(list(map(int, input().split())))
#
# for i in range(1, N + 1):
#     weight, value = bag[i][0], bag[i][1]
#     print(weight, value)
#     for j in range(1, K + 1):
#         if j < weight:
#             dp_table[i][j] = dp_table[i - 1][j]
#             print("j, weight= ", j, weight)
#             continue
#
#         dp_table[i][j] = max(dp_table[i - 1][j - weight] + value, dp_table[i - 1][j])
#     print('----------------------------')
#     for p in dp_table:
#         print(p)
#     print('----------------------------')
# print(dp_table[N][K])



# 처음 시도했는데 틀린 풀이
# N, K = map(int, input().split())
# value_weight = []
#
# for i in range(N):
#     value, weight = map(int, input().split())
#     value_weight.append((value, weight))
#
# value_sum = 0
# weight_sum = 0
# max_value = -1e9
# count = 0
#
# def dfs(weight_sum, value_sum, count):
#     global max_value, value_weight
#     if weight_sum > K or count > len(value_weight) :
#         return
#
#     if count ==len(value_weight) :
#         if weight_sum <= K:
#             max_value = max(max_value, value_sum)
#             return max_value
#     else:
#         dfs(weight_sum + value_weight[count][0], value_sum + value_weight[count][1], count + 1)
#         dfs(weight_sum, value_sum, count + 1)
#
#
#
# def bfs(weight_sum,value_sum, count) :
#     q = deque()
#     q.append((weight_sum, value_sum, count))
#
#     while q :
#         if weight_sum > K or count > len(value_weight) :
#             return
#
#         if count == len(value_weight) :
#             if weight_sum <= K :
#                 max_value = max(max_value, value_sum)
#             return max_value
#
#         else :
#             q.append((weight_sum + value_weight[count][0], value_sum + value_weight[count][1], count + 1))
#             q.append((weight_sum, value_sum, count + 1))
#
#     return max_value
# dfs(0, 0, 0)
# print(max_value)
