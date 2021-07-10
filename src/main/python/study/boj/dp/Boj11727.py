N = int(input())
memoi = [-1] * 1001

memoi[1] = 1
memoi[2] = 3
memoi[3] = 5

def func(x):
    if memoi[x] != -1 :
        return memoi[x]

    for i in range(1, N + 1):
        if memoi[i] == -1:
            memoi[x] = func(x - 1) + (func(x - 2)) * 2

    return memoi[x]

func(N)
print(memoi[N] % 10007)

