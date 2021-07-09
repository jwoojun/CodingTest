def productSum(array, count=1) :
    answer = 0
    for i in array :
        if type(i) is not list :
            answer += i
        else :
            answer += productSum(answer, count+1)

    return answer * count