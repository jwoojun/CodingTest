# 수 묶기
left, mid, right = [], [], []
N = int(input())
numbers = [int(input()) for _ in range(N)]

for i in numbers:
    if i <= 0:
        left.append(i)
    elif i == 1 :
        mid.append(i)
    else:
        right.append(i)

left.sort(), right.sort(reverse=True)
answer = []

if len(left) % 2 == 0:
    for i in range(0, len(left) - 1, 2):
        answer.append(left[i] * left[i + 1])
else:
    for i in range(0, len(left) - 1, 2):
        answer.append(left[i] * left[i + 1])
    answer.append(left[-1])

if len(right) % 2 == 0:
    for i in range(0, len(right) - 1, 2):
        answer.append(right[i] * right[i + 1])

else:
    for i in range(0, len(right) - 1, 2):
        answer.append(right[i] * right[i + 1])
    answer.append(right[-1])
answer.extend(mid)
print(sum(answer))