import copy
def solution(phone_book) :
    # lambda를 이용해 글자수가 짧은 것들을 앞으로 정렬
    phone_book.sort(key=lambda x : len(x))
    for i in range(len(phone_book)) :

        for j in range(i+1, len(phone_book)) :
            an = len(phone_book[i])

            # 접두어는 앞만 해당하기 때문에 phone_book[j][:an]을 통해 앞 부분만 비교하도록 설정
            if phone_book[i] == phone_book[j][:an] :
                return False

    else :
        return True


# 출처 : https://programmers.co.kr/learn/courses/30/lessons/42577