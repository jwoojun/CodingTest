import sys
input = sys.stdin.readline
N, M = map(int, input().split(" "))
lst = list(map(int, input().split(" ")))
lst.sort()

start, end = 0, len(lst)
ans = 0
while(start<=end) :

    mid =(start+end)//2

    length=0
    # 13 <15> 17
    for i in range(N) :
        if lst[mid] <= lst[i] :
            length += (lst[i] - lst[mid])
    if (length >= M) :
        ans = mid
        start = mid +1
    elif length < M :
        end = mid-1

print(ans)