import sys

N, x = map(int,input().split())
numbers = list(map(int,input().split()))

check = []

start = 0
end = len(numbers)

while start <= end :
    mid = (start+end)//2

    if numbers[mid] == x :
        if numbers[mid] not in check :
            check.append(mid)


    elif numbers[mid] > x :
        end = mid-1

    else :
        start = mid+1

    print(check)
print(check)


# Test Case
# 7 2
# 1 1 2 2 2 2 3