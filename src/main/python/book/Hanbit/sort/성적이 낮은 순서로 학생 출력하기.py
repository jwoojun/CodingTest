N = int(input())

ans =[]
for i in range(N) :
    data = input().split()
    ans.append((data[0], data[1]))

ans = sorted(ans, key=lambda x : x[1])

for j in ans :
    print(j[0], end = " ")


# 출처 : 이것이 코딩테스트다 (p180)