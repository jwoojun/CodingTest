import sys
import math

input = sys.stdin.readline
N = int(input())


def catal(N):
    return math.factorial(2 * N) // (math.factorial(N) * math.factorial(N + 1))


for i in range(N):
    number = int(input())
    if number % 2 != 0:
        print(0)
    else:
        print(catal(number // 2) % 1000000007)
