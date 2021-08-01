def productSum(lst, num=1) :
    sum_=0
    for i in lst :
        if type(i) is list :
            sum_ += productSum(i, num+1)
            print(i, sum_, num)

        else :
            sum_ += i

    return sum_*num


# 출처 : https://www.algoexpert.io/questions



