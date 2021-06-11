def solution(lst) :
    number = []
    alpha = []

    # 숫자와 문자를 분리
    for i in range(len(lst)):
        if lst[i].isalpha():
            alpha.append(lst[i])

        else:
            number.append(lst[i])

    # 각 문자 정렬
    alpha.sort()
    number.sort()
    return ''.join(alpha) + ''.join(number)


# 출처 : 이것이 코딩테스트다 p322