numberList = [0]*10000
def recursive(n) :
    numberList[1], numberList[2] = 1, 2
    if n == 1 :
        return numberList[1]
    if n == 2 :
        return numberList[2]


    else :
        numberList[n] = numberList[n-2] + numberList[n-1]

    return recursive(n-1) + recursive(n-2)



print(recursive(5))


from itertools import combinations

def powerset(array):
    answer = []
    for i in range(0, len(array) + 1):
        b = list(combinations(array, i))
        for j in b:
            if j not in answer:
                answer.append(list(j))

    return answer
