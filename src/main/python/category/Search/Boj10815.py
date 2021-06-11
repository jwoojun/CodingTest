N = int(input())
lst = list(map(int, input().split(" ")))
M = int(input())
lst2 = list(map(int, input().split(" ")))
result = []

def binary_search(lst, key) :
    start = 0
    end = len(lst) - 1

    while(start<=end) :
        mid = (start+end) // 2

        if(lst[mid]==key) :
            result.append(1)
            return

        elif (key < lst[mid]) :
            end = mid-1

        elif (key > lst[mid]) :
            start = mid+1

    result.append(0)
    return

lst.sort()
for i in range(len(lst2)) :
    binary_search(lst, lst2[i])

for i in result :
    print(i, end=" ")
