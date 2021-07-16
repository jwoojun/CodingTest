import sys
from collections import deque

input = sys.stdin.readline

#
# N = int(input())
# homework = []
# answer= 0
# for i in range(N) :
#     day, score = map(int,input().split())
#     homework.append((day, score))
# homework.sort(key=lambda x:(x[0], x[1]), reverse=True)
# print(homework)


n = int(input())
homeworks = []
for _ in range(n):
    deadline, score = map(int, sys.stdin.readline().split())
    homeworks.append((deadline, score))
homeworks.sort()
can = []
date = homeworks[-1][0]
answer = 0

while True:
    print("answer= ",answer)
    if date == 0:
        break

    while homeworks and homeworks[-1][0] >= date:
        print(can)
        print(homeworks, date)
        can.append(homeworks.pop()[1])
        print('----------------------------------------------------')
    date -= 1
    if not can:
        print(can)
        continue
    print("=============")
    print(can)
    can.sort()
    print("=============")
    answer += can.pop()
print(answer)
