def monotonicIncrement(array):
    for i in range(len(array) - 1):
        if array[i] <= array[i + 1]:
            pass
        else :
            return False
    return True


def monotonicDecrement(array):
    for i in range(len(array) - 1):
        if array[i] >= array[i + 1]:
            pass
        else:
            return False
    return True


def lenChecker(array) :
    if len(array) < 2 :
        return True


def isMonotonic(array):
    if lenChecker(array): return True
    if monotonicIncrement(array) :
        return True
    if monotonicDecrement(array) :
        return True
    return False
