def solution(array) :
    isSorted = False
    count = 0

    while not isSorted :
        isSorted = True
        for i in range(len(array)-1-count) :
            if array[i] > array[i+1] :
                swap(i, i + 1, array)
                isSorted = False if isSorted == True else False
        count += 1
    return array


def swap(i, j, array) :
        array[i], array[j] = array[j], array[i]