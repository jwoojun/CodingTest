import sys

input = sys.stdin.readline
N = int(input())
numbers = [int(input()) for _ in range(N)]
minus = []
mid = []
plus = []
ans = []
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
        ans.append(minus[i] * minus[i + 1])
else:
    for i in range(0, len(minus) - 1, 2):
        ans.append(minus[i] * minus[i + 1])
    ans.append(minus[-1])


if (len(plus) % 2 == 0):
    for i in range(0, len(plus) - 1, 2):
        ans.append(plus[i] * plus[i + 1])

else:
    for i in range(0, len(plus) - 1, 2):
        ans.append(plus[i] * plus[i + 1])
    ans.append(plus[-1])

ans.extend(mid)
print(sum(ans))