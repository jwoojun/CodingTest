# Bubble Sort
def bubble_sort(lst) :
    for i in range(len(lst)-1) :
        for j in range(len(lst)-i-1) :
            if lst[j] < lst[j+1] :
                lst[j], lst[j+1] = lst[j+1], lst[j]
                print(lst)

    return lst




def bubble_sort2(lst) :
    for i in range(len(lst)-1) :
        for j in range(len(lst)-i-1) :
            if lst[j] < lst[j+1] :
                lst[j], lst[j+1] = lst[j+1], lst[j]
                print(lst)
    return lst


lst= [5,3,2,1,4,3,10,12,19,40]
print(bubble_sort2(lst))



