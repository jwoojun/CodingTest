def solution(citations):
    max_ = 0
    for i in range(1, len(citations) + 1):
        over = below = 0

        for j in range(len(citations)):
            if i <= citations[j]:
                over += 1
            elif (i >= citations[j]):
                below += 1

        if (over >= i) & (below <= i) & (i > max_):
            max_ = i

    return max_


# 출처 : https://programmers.co.kr/learn/courses/30/lessons/42747