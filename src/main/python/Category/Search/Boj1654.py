# import sys
# N, K = map(int, input().split())
# lst = [int(sys.stdin.readline()) for _ in range(N)]
# lst.sort()
#
# start = 1
# end = max(lst)
# answer = 0
# while (start<=end) :
#     count = 0
#     mid = (start+end)//2
#     for i in range(N) :
#         mid = int((mid/10)*10)
#         count += (lst[i]//mid)
#     if (count>=K) :
#         start = mid+1
#         answer = mid
#
#     else :
#         end = mid-1
# print(answer)



X, Y = map(int, input().split())
Z = (int((int(Y) / int(X)) * 100))

start = 1
end = X
answer = 0

while(start <= end) :

    if (X == Y) :
        answer = -1
    mid = (start+end)//2

    if(int((int(Y+mid)/int(X+mid)) * 100)) == Z :
        start = mid+1
    else :
        end = mid-1
        answer = int((int(Y + mid) / int(X + mid)) * 100)

if (answer == Z) :
    print(-1)
else :
    print(mid)






