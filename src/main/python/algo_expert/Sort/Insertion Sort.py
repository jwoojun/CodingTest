def insertionSort(array):
	for i in range(len(array)-1) :
		for j in range(i+1, len(array)) :
			if array[j] < array[i] :
				array[i], array[j] = array[j], array[i]
	return array



def swap(x, y, array) :
    array[x], array[y] = array[y], array[x]

def insertionSort(array) :
    for i in range(1, len(array)) :
        j = i
        while j > 0 and array[j] < array[j-1] :
            swap(j, j-1, array)
            j -= 1
            print(array)
    return array

# 출처 : https://www.algoexpert.io/questions/Insertion%20Sort


