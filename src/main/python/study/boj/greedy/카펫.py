def solution(brown, yellow) :
    # 노란색의 갯수에 따라 결정되기 때문에 노란색의 약수를 기준으로 생각
    lst = []
    for i in range(1, yellow+1) :
        if yellow % i == 0 :
            lst.append(i)

    # (노란색 가로+2) * (노란색 세로+2) = (brown+yellow)
    for j in range(len(lst)) :
        if (lst[j]+2) * (lst[len(lst)-j-1]+2) == yellow+brown :
            return [(lst[len(lst)-j-1]+2), (lst[j]+2)]