# 이진수2
def solution(n) :
    global sum_
    sum_ = ""
    while n != 1:
        if len(sum_) >= 13:
            return "overflow"
            break
        else:
            n *= 2
            sum_ += str(int(n))
            if n > 1:
                n -= 1
            else:
                continue

    return sum_

N = int(input())
for i in range(N) :
    n = float(input())
    print(f'#{i+1} {solution(n)}')


# 출처 : https://swexpertacademy.com/main/solvingProblem/solvingProblem.do