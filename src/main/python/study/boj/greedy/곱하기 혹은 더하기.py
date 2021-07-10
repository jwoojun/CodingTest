def solution(lst) :
    sum_ = 0

    for i in range(len(lst)):
        if sum_ == 0:
            sum_ += int(lst[i])
        else:
            if (int(lst[i]) == 0 or 1)  or (sum_ == 1) :
                sum_ += int(lst[i])
            else:
                sum_ *= int(lst[i])
    return sum_