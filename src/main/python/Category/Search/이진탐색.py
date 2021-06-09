def binary_search(lst, target) :
    start, end = 0, len(lst)-1
    location = 0
    while (start<=end):
        mid = (start+end)//2
        if lst[mid] == target :
            return 1

        elif lst[mid] < target :
            start = mid + 1
            if location == 1 :
                return 0
            location = 1

        else :
            end = mid - 1
            if location == -1 :
                return 0
            location = -1


    return 0

N = int(input())
for i in range(N) :
    x, y = map(int, input().split())
    x_list= sorted(list(map(int, input().split())))
    y_list = list(map(int, input().split()))
    count = 0
    for j in range(len(y_list)) :
        count += binary_search(x_list, y_list[j])
    print(f'#{i + 1} {count}')


# 출처 : https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do