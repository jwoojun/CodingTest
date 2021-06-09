import math
import sys

input = sys.stdin.readline
n = int(input())
answer = []
for i in range(n):
    answer.append(int(input()))

max_number = max(answer)
prime_numbers = [[True] for _ in range(max_number + 1)]
for i in range(2, int(math.sqrt(max_number)) + 1):
    j = 2
    while i * j <= max_number:
        prime_numbers[i * j] = False
        j += 1
save = 0
prime = []

for i in range(1, max_number + 1):
    if (prime_numbers[i]):
        prime.append(i)
prime_numbers = prime[1:]


def find(number):
    for i in prime_numbers:
        for j in prime_numbers:
            if out:
                out = False
                break
            for k in prime_numbers:
                if i + j + k > 1001:
                    break
                if i + j + k == number:
                    lst = [i, j, k]
                    lst.sort()
                    out = True
                    return lst


for i in answer:
    if find(i):
        a, b, c = find(i)
        print(a, b, c)
    else:
        print(0)