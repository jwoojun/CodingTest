N = int(input())

lst = []

for i in range(N) :
    input_data = input().split()
    lst.append((input_data[0]), int(input_data[1]))

lst = sorted(lst, key = lambda x : x[1])

for j in lst :
    print(j[0], end=' ')


# 출처 : 이것이 코딩테스트다(p180)