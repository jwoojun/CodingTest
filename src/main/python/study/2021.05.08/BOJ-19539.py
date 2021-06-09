N = int(input())
trees = list(map(int, input().split()))

if sum(trees) % 3 != 0:
    print("NO")
else:
    count = 0
    for i in trees:
        count += (i // 2)
    if count >= sum(trees) // 3:
        print("YES")
    else:
        print("NO")