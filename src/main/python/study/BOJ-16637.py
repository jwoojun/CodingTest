import sys

input = sys.stdin.readline
N = int(input())
text = list(map(str, input().split()))
print(text)
lst = list(text)

numbers, others = [], []

for i in range(len(lst[0])):
    if lst[0][i].isdigit():
        numbers.append(int(lst[0][i]))

    else:
        others.append(lst[0][i])
numbers.sort()
print(numbers, others)
