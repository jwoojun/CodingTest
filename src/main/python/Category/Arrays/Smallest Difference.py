def smallestDifference(arrayOne, arrayTwo):
    _min = 99999999999
    x = y = 0
    for i in range(len(arrayOne)):
        for j in range(len(arrayTwo)) :
            check = abs(arrayOne[i] - arrayTwo[j])
            if _min > check :
                _min = check
                x, y = i, j

    return [arrayOne[x], arrayTwo[y]]


def findBigNumber(x, y) :
    if x > y :
        x, y = y, x
    return

arrayOne=[-1, 5, 10, 20, 28, 3]
arrayTwo=[26, 134, 135, 15, 17]
print(smallestDifference(arrayOne, arrayTwo))