n = int(input())




# import sys
#
# input = sys.stdin.readline
#
# N = int(input())
# numbers = list(map(int, input().split()))
# sCount = list(map(int, input().split()))
# s = ["+", "-", "*", "//"]
# visited = [False for _ in range(N)]
# answer = []
#
#
# def dfs(i, x, visited):
#     visited[i] = True
#     print((visited), x)
#     for j in range(N):
#         if not visited[j]:
#             for k in range(4):
#                 if sCount[k] != 0 :
#                     x += numbers[k]
#                     dfs(j, x, visited)
#                     visited[j] = False
#
#     if visited[N - 1] == True:
#         answer.append(x)
#         return
#
#
# for i in range(N):
#     x = numbers[0]
#     dfs(i, x, visited)
#     visited[i] = False
#
# print(max(answer))
# print(min(answer))
