import sys

input = sys.stdin.readline

N, M = map(int, input().split())
lst = []

answer = []
for i in range(N) :
    lst.append(list(map(int, input().split())))


for i in range(len(lst)) :
    answer.append(min(lst[i]))

print(max(answer))

# 테스트 케이스(1)
# 3 3
# 3 1 2
# 4 1 4
# 2 2 2


# 테스트 케이스(2)
# 2 4
# 7 3 1 8
# 3 3 3 4