N = int(input())
memoi =[-1] * 1001

def fibo(x) :
    memoi[1] = 1
    memoi[2] = 2
    if x == 1 :
        return memoi[1]
    if x ==2 :
        return memoi[2]

    for i in range(x+1) :
        if memoi[x] == -1 :
            memoi[x] = fibo(x-2) + fibo(x-1)
        else :
            return memoi[x]

fibo(N)
print(memoi[N]%10007)


