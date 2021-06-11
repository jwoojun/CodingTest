def solution(n):
    answer = ''
    while n > 0 :
        answer = '412'[(n) % 3] + answer
        if n %3 ==0 :
            n = (n//3 -1)
        else :
            n = (n//3)
    return answer