def twoNumberSum(array, targetSum) :
    a = b = 0
    for i in range(len(array)-1) :
        for j in range(i+1, len(array)) :
            if array[i]+array[j] == targetSum :
                    a, b = array[i], array[j]
                    answer = [a, b]
                    return answer
    return []


# 출처 : https://www.algoexpert.io/product