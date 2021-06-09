# 컴퓨터로부터 1~45사이의 5개의 숫자를 랜덤으로 입력받습니다. 유저 또한 1~45사이의 5개의 숫자를 입력해서 같은 숫자의 갯수를 출력하는 프로그램을 만드세요.
# 유저가 45가 넘는 값을 입력했을 경우 "올바른 범위를 입력해주세요"라는 경고메시지를 띄우세요.

import random
# 복잡도 안 고려하고 코드 짰습니다.
def comNumber2() :
    # 랜덤 함수를 생성
    random_ = random.sample(list(range(1, 46)), 6)

    # count는 몇 번째 수를 입력받는지, answer은 출력될 답의 갯수(동일한 원소)
    count = answer = 0

    # user가 입력할 6개의 숫자가 들어갈 배열
    userNumber = []


    # user가 입력한 숫자가 6개가 되기 전까지 입력받기
    while (len(userNumber) < 6) :
        print(f'{count+1}번째 숫자를입력해주세요.')
        a = int(input())

        # 범위에 맞지 않으면 빡구
        if a<=45 and a>=1 and (a not in userNumber) :
            userNumber.append(a)
            count += 1
        else :
            if a > 45 or a < 1 :
                print('올바른 범위를 입력해주세요.')
            else :
                print('동일한 값이 있습니다.')




    # 이중 for문으로 하나씩 돌면서 원소의 갯수가 같은 경우 answer += 1해주는 것.
    for i in range(len(userNumber)) :
        for j in range(len(userNumber)) :
            if random_[i] == userNumber[j] :
                answer +=1
                break

    # 보기 편하게 하려고 정렬.
    random_.sort(), userNumber.sort()
    print(userNumber)

    print(random_)

    return answer


print(comNumber2())