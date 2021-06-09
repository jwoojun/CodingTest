import sys
input = sys.stdin.readline
N = int (input())
food_times = [int(input()) for _ in  range(N)]
k = int(input())

count =sum(food_times)
increase=0
num = len(food_times)

while (k != 0):
    if (food_times[increase % num] != 0):
        food_times[increase % num] -= 1
        count -= 1
        k -= 1

    else:
        increase += 1
        continue

    if count == 0 :
        print(-1)
        break
    increase += 1
print((increase % num)+1)


def solution(food_times, k):
    count = sum(food_times)
    increase = 0
    num = len(food_times)
    while (k != 0):
        if (food_times[increase % num] != 0):
            food_times[increase % num] -= 1
            count -= 1
            k -= 1

        else:
            increase += 1
            continue

        if count == 0:
            print(-1)
            break
        increase += 1
    return (increase % num)+1