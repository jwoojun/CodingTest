N, K =map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))


A.sort(), B.sort(reverse=True)
for i in range(K) :
    if A[i] < B[i] :
        A[i], B[i] = B[i]. numbers[i]

    else :
        break


# 출처 : 이것이 코딩테스트다. (p182)