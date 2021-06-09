from itertools import permutations


def find(n):
    if n <= 1 :
        return False

    for i in range(2, n):
        if n % i == 0:
            return False

    else:
        return True
def solution(numbers):
    answer, count = [], 0
    for i in range(1, len(numbers)+1):
        a = list(map(''.join, permutations(list(numbers), i)))
        for j in list(set(a)):
            if find(int(j)) :
                answer.append(int(j.lstrip('0')))

    return len(set(answer))


# 출처 : https://programmers.co.kr/learn/courses/30/lessons/42839
