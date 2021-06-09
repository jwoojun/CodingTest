def quick_sort(array) :

    if len(array) <= 1 :
        return array

    pivot, tail = array[0], array[1:]

    left_side = [i for i in tail if i<= pivot]
    right_side = [i for i in tail if i > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)






def quick_sort(array, left, right):
    if right - left <= 1:
        return

    pivot = array[left]
    i, j = left, right

    while i < j:
        while pivot < array[j]:
            j -= 1

        while i < j and pivot >= array[i]:
            i += 1

        array[j], array[i] = array[i], array[j]


    array[left] = array[i]
    array[i] = pivot

    quick_sort(array, left, i)
    quick_sort(array, i + 1, right)

    return array
array = [1,5,4,3,2]
print(quick_sort(array, 0, 4))





# QuickSort3
def quickSort(array) :
    quickSortHelper(array, 0 ,len(array)-1)
    return array

def quickSortHelper(array, startIndex, endIndex) :
    if startIndex >= endIndex :
        return

    pivotIndex = startIndex
    leftIndex, rightIndex = startIndex+1, endIndex

    while rightIndex >= leftIndex :
        if (array[leftIndex] > array[pivotIndex]) and (array[rightIndex] < array[pivotIndex]) :
            swap(leftIndex, rightIndex, array)
        if array[leftIndex] <= array[pivotIndex] :
            leftIndex += 1

        if array[rightIndex] >= array[pivotIndex] :
            rightIndex -= 1

        swap(pivotIndex, rightIndex, array)
        leftSubarrayIsSammler = rightIndex -1 -startIndex < endIndex - (rightIndex+1)


        if leftSubarrayIsSammler :
            quickSortHelper(array, startIndex, rightIndex-1)
            quickSortHelper(array, rightIndex,+1, endIndex)
        else :
            quickSortHelper(array, rightIndex+1, endIndex)
            quickSortHelper(array, startIndex, rightIndex-1)



def swap(i, j, array) :
    array[i], array[j] = array[j], array[i]
