import sys

input = sys.stdin.readline

N = int(input())
trees = list(map(int, input().split()))
countNo2 = sum(trees) // 3

count = 0
if sum(trees) % 3 != 0:
    print("NO")

else:
    for i in trees:
        count += i//2

    if count >= countNo2:
        print("YES")
    else:
        print("NO")
