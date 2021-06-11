N = int(input())

answer =[]
for i in range(N) :
    data = input().split()
    answer.append((data[0], data[1]))

answer = sorted(answer, key=lambda x : x[1])

for j in answer :
    print(j[0], end = " ")


# 출처 : 이것이 코딩테스트다 (p180)