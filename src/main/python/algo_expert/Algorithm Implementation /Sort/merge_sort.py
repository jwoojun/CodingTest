def merge_sort(lst) :
    if len(lst) <= 1 :
        return lst

    mid = len(lst) // 2
    left_ = lst[:mid]
    right_ = lst[mid:]

    l = merge_sort(left_)
    r = merge_sort(right_)
    return Merge(l, r)




def Merge(left_, right_) :
    answer = []
    i = j = 0
    while (i < len(left_)) & (j<len(right_)) :
        if left_[i] < right_[j] :
            answer.append(left_[i])
            i += 1
        else :
            answer.append(right_[j])
            j += 1

    answer += left_[i:]
    answer += right_[j:]

    return answer


# 출처 : https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do