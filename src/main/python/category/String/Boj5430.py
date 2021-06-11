import sys

input = sys.stdin.readline


def rev(lst):
    lst = lst[::-1]
    return lst


def popleft(x):
    return x.pop(0)


answer = []
for i in range(int(input())):
    p = list(input().rstrip())
    n = int(input())
    x = list(map(int, input().split()))
    print("start")
    for j in range(len(p)):
        if p[j] == "R":
            x = rev(x)
        else:
            if len(x) == 0 :
                print("error")
                continue
            else :
                popleft(x)
