N = int(input())
K = input().split()
check = [False] * 10
max_, min_ = "", ""


def possible(x, y, k):
    if k == "<":
        return x < y
    if k == ">":
        return x > y
    return True


def solve(cnt, s):
    global max_, min_
    if cnt == N + 1:
        if not len(min_):
            min_ = s
        else:
            max_ = s
        return

    for i in range(10):
        if not check[i]:
            if cnt == 0 or possible(s[-1], str(i), K[cnt - 1]):
                check[i] = True
                solve(cnt + 1, s + str(i))
                check[i] = False


solve(0, "")
print(max_)
print(min_)
