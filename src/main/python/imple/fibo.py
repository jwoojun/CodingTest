memoi = [0] * 1001


def fibo(x):
    memoi[1], memoi[2] = 1, 1
    if x == 1 or x == 2:
        return memoi[1]

    if memoi[x] != 0:
        return memoi[x]

    memoi[x] = fibo(x - 1) + fibo(x - 2)
    return memoi[x]


# Bottom-up
memoi2 = [0] * 1001
memoi2[1], memoi2[2] = 1, 1


def fibo2(x):
    for i in range(3, x + 1):
        memoi2[i] = memoi2[i - 1] + memoi2[i - 2]
