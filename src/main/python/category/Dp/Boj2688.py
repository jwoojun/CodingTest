import sys
input = sys.stdin.readline
def c(x):
    x = str(x)
    a = list(x)
    for i in range(len(a) - 1):
        if int(a[i]) > int(a[i + 1]):
            return False

    return True
# real = []
# def ans (x) :
#     for i in x :
#         count = 0
#         answer = 0
#         while count < 10**i:
#             if (c(count)):
#                 answer += 1
#
#             count += 1
#         real.append(answer)
#     return real
#
# N = int(input())
# num = [int(input()) for _ in range(N)]
# ans(num)
# for i in real :
#     print(i, end=' ')





count = 0
answer = 0
while count < 1000000:
    if (c(count)):
        answer += 1

    count += 1
print(answer)
