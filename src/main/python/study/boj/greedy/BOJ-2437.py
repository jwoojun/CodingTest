# 저울
import sys

input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

data.sort()

# 만들고 싶은 금액 -> target을 만들고 싶은데 다음에 주어진 수가 x
answer= 0
accumulatedSum = 0
for weight in data :
    if weight > accumulatedSum+1 :
        break
    accumulatedSum += weigh t
print(accumulatedSum+1)

# target = 1
# for x in data:
#     if target < x :
#         break
#     target += x
# print(target)


# 만들고 싶은 금액 -> target을 만들고 싶은데 다음에 주어진 수가 x   ->  https://woongsios.tistory.com/133
# ex) target이 5인 경우 4까진 만들 수 있는데 다음에 주어진 수가 3이면 8을 만들 수 있다.

# ----------------------------------------
# |array  0   1   1   2   3   6   7   30 |
# |target 1   2   3   5   8  14  21   51 |
# ----------------------------------------


