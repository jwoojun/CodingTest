import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
numbers = list(map(int, input().split()))

visited = [True] + [False] * (N - 1)


def visitable(index):
    return index < N and not visited[index]


def bfs(index, count):
    q = deque([[index, count]])

    while q:
        index, count = q.popleft()
        if index + 1 == N:
            return count
        for i in range(numbers[index] + 1):
            next_index = index + i
            if visitable(next_index):
                visited[next_index] = True
                q.append((next_index, count + 1))

    return -1


print(bfs(0, 0))

# def f(x, idx, ans):
#     if x == 0:
#         return ans
#     temp = -1
#     while idx != 0:
#         print(idx, temp, ans, a[idx])
#         idx -= 1
#         if a[idx] + idx < x:
#             continue
#         temp = idx
#     if temp == -1:
#         return -1
#     ans += 1
#     return f(temp, temp, ans)
#
# n = int(input())
# a = list(map(int,input().split()))
# ans = 0
# print(f(n-1, n-1, ans))

#
# N = int(input())
# numbers = list(map(int, input().split()))
# start = 0
# min_result = int(1e9)
# visited = [False]*9999999
