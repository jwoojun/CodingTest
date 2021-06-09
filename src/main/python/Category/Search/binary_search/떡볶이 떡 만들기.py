import sys

input = sys.stdin.readline

N, M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()


def binary_search(lst, target):
    start = 0
    end = max(lst)
    result = 0
    while start<=end:
        total = 0
        mid = (start + end) // 2
        for i in lst:
            if i > mid:
                total += i - mid
        if total < target:
            end = mid-1
        else :
            result = mid
            start = mid+1
    return result
print(binary_search(lst, M))