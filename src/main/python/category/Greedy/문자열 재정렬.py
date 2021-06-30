# 문자열 재정렬
def solution(alphabet):
    number = 0
    lst = list(alphabet)
    alpha = []

    # 숫자와 문자를 분리
    for i in range(len(lst)):
        if lst[i].isalpha():

            alpha.append(lst[i])


        else:
            number += int(lst[i])
    # 각 문자 정렬
    alpha.sort()
    return ''.join(alpha) + str(number)


print(solution("AJKDLSI412K4JSJ9D"))

# TestCase
# K1KA5CB7
# AJKDLSI412K4JSJ9D
