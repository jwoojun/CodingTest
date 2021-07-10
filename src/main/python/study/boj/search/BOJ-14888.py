# 연산자 끼워넣기(2)
import sys

input = sys.stdin.readline
N = int(input())
numbers = list(map(int, input().split()))
plus, minus, mul, div = map(int, input().split())
min_result = 1e9
max_result = -1e9


def dfs(index, result, plus, minus, mul, div):
    global min_result, max_result
    if index == N:
        max_result = max(max_result, result)
        min_result = min(min_result, result)
        return

    if plus > 0:
        dfs(index + 1, result + numbers[index], plus - 1, minus, mul, div)

    if minus > 0:
        dfs(index + 1, result - numbers[index], plus, minus - 1, mul, div)

    if mul > 0:
        dfs(index + 1, result * numbers[index], plus, minus, mul - 1, div)
    if div > 0:
        dfs(index + 1, int(result / numbers[index]), plus, minus, mul, div - 1)


dfs(1, numbers[0], plus, minus, mul, div)
print(max_result)
print(min_result)
a = -31
b = 2
print(a // b)
print(int(a / b))
