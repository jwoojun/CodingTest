from collections import defaultdict

n = int(input())
dic_before = defaultdict(list)
dic_after = defaultdict(list)
cars = []
for i in range(2 * n):
    board = input().rstrip()
    cars.append(board)
    if (i < n):
        dic_before[board].append(n-(i))
        # print(dic_before[board])
    else:
        dic_after[board].append((i + 1) - ((2 * n) // 2))
        # print(board)
        # print("Else")
        # print((i+1)-(2*n)//2)

count = 0

for i in dic_after :
    if dic_after[i][0] < dic_before[i][0] :
        count += 1

print(count)
# A B C
# C B A
print(dic_before)
print(dic_after)

# 1,2,3,4,5,6,7,8
