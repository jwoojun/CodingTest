# BOJ-1038 감소하는 수
N = int(input())

def findDecreaseNumber(number, digits, lst):
    lst.append(number)

    for i in range(10):
        if (number % 10 > i):
            findDecreaseNumber(number * 10 + i, digits + 1, lst)

if N > 1022:
    print(-1)
else:
    lst = list()
    for i in range(10):
        findDecreaseNumber(i, 1, lst)
        lst.sort()
    print(lst[N])