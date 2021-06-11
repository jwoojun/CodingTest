from itertools import combinations


def solution(clothes):
    category = {}
    answer = 1
    for i in range(len(clothes)):
        if clothes[i][1] in category:
            category[clothes[i][1]].append(clothes[i][0])
        else:
            category[clothes[i][1]] = [clothes[i][0]]
    for i in category:
        answer *= (len(category[i]) + 1)

    return answer - 1
