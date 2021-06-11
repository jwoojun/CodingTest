def getNthFib(n):
    if n == 2:  return 1
    elif n == 1: return 0
    else: return getNthFib(n - 1) + getNthFib(n - 2)



lst = [0] * 10000
def getNthFib(n) :
    lst[1], lst[2] = 0, 1
    if n == 1 : return lst[1]
    if n == 2 : return lst[2]
    if lst[n] == 0 :
        lst[n] = getNthFib(n-1)+ getNthFib(n-2)
        return lst[n]
    return lst[n]