# selection_sort
def selection_sort(lst) :
    for i in range(len(lst)-1) :
        min_ = i
        for j in range(i+1, len(lst)) :
            if lst[min_] > lst[j] :
                min_ = j
    lst[i], lst[min_] = lst[min_], lst[i]

    return lst

