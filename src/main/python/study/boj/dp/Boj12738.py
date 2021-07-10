# import sys
# input = sys.stdin.readline
#
# # 유형 3번
# def find_location(start, end, number) :
#     while(start<end) :
#         mid = (start+end)//2
#         if (answer[mid]<number) :
#             start = mid+1
#         else :
#             end = mid
#     return end
#
# N =  int(input())
# lst = list(map(int, input().split()))
# answer = [lst[0]]
#
# for i in lst :
#     if answer[-1] < i :
#         answer.append(i)
#     else :
#         index = find_location(0, len(answer), i)
#         answer[index] = i
# print(len(answer))

def func(a = []):
  a.append('3')
  return a

s=func()
s