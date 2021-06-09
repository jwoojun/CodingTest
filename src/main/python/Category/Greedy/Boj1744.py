import sys

input = sys.stdin.readline
N = int(input())
numbers = [int(input()) for _ in range(N)]
minus = []
mid = []
plus = []
answer = []
for i in numbers:
    if i <= 0:
        minus.append(i)
    elif i > 1:
        plus.append(i)
    else:
        mid.append(i)
minus.sort()
plus.sort(reverse=True)

if (len(minus) % 2 == 0):
    for i in range(0, len(minus) - 1, 2):
        answer.append(minus[i] * minus[i + 1])
else:
    for i in range(0, len(minus) - 1, 2):
        answer.append(minus[i] * minus[i + 1])
    answer.append(minus[-1])


if (len(plus) % 2 == 0):
    for i in range(0, len(plus) - 1, 2):
        answer.append(plus[i] * plus[i + 1])

else:
    for i in range(0, len(plus) - 1, 2):
        answer.append(plus[i] * plus[i + 1])
    answer.append(plus[-1])

answer.extend(mid)
print(sum(answer))