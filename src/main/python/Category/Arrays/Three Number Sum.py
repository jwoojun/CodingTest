def threeNumberSum(array, targetSum):
    array.sort()
    answer = []
    count = 0
    for i in range(len(array) - 2):
        for j in range(i + 1, len(array) - 1):
            for k in range(j, len(array)):
                if array[i] + array[j] + array[k] == targetSum:
                    if array[i] != array[j] and array[i] != array[k] and array[j] != array[k]:
                        answer.append([array[i], array[j], array[k]])
                        count += 1

    if count == 0:
        return []

    return answer


# https://www.algoexpert.io/questions