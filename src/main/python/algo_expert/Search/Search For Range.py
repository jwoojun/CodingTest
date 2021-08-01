def searchBinary(array, target) :
    if target not in array:
        return -1
    for i in range(len(array)) :
        if array[i] == target :
            return i

def reverse (array, target) :
    reverse = array[::-1]
    if target in array :
        return (len(array) - 1 - reverse.index(target))

    return -1

def searchForRange(array, target) :
    return [searchBinary(array, target), reverse(array, target)]