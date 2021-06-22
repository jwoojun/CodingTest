# 부분합
import sys

input = sys.stdin.readline
N, S = map(int, input().split())
numbers = list(map(int, input().split()))
min_length = 1e9


def subSum(numbers, target, N):
    sub_sum = 0
    start = end = 0
    min_length = 1e9

    while 1:
        if sub_sum >= target:
            min_length = min(min_length, end - start)
            sub_sum -= numbers[start]
            start += 1

        elif end == len(numbers):
            break

        else:
            sub_sum += numbers[end]
            end += 1
    return min_length


if subSum(numbers, S, N) == 1e9:
    print(0)
    exit()
print(subSum(numbers, S, N))



sub_sum=numbers[0]
end = 0
answer = 1e9
for start in range(N) :
    while sub_sum < S and end < N :
        end += 1
        if end == N :
            break

        sub_sum += numbers[end]

    if sub_sum >= S :
        answer = min(answer, end-start+1)
    sub_sum -= numbers[start]

if answer == 1e9 :
    print(0)
    exit()
print(answer)