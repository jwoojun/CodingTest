# number="1231234"
import copy





def solution(number, k) :
    number = list(number)

    # 앞자리 가장큰 수, 전체 길이
    max_save, length = "", len(number)

    # deepcopy로 복사
    d = copy.deepcopy(number)

    # 남아야 하는 수
    start = length - k -1
    control = len(number)-start
    front = number[:start]
    back = number[start:]
    max_i = front[0]
    for i in front :
        if max_i < i :
            max_i = i
    print('back:', back)


    # 최고수의 위치
    location = front.index('7')

    # 최고수 제외 한 빼 갯수
    count = len(number[:location+1])-1
    start += 1
    a = number[location+1:start+1]

    k -= count
    max_save += max_i
    print('최고수설정 끝')

    # if len(result) == len(number):
        # break
#             min_i = min(d)
#             d += number[start]
#             d.remove(min_i)
#             start += 1
#             k -= 1
#         l = ''.join(d)
#         result = answer + l
#
#     return result
# #
number= "4177252841"
print(solution(number, 4))
#
#
# number="1231234	"
# import copy
# number = list(number)
# answer = ""
# k = 3
# b = len(number)
#
# # 뒤에 여기부터 시작
# start = (b - k+1)
#
# location = 0
# number[location : start]
#
# max_i = 0
# for i in range(len(number)):
#     if number[max_i] < number[i]:
#         ma_x = number[i]
# d = copy.deepcopy(number)
# count = 1
# while (k > 0) :
#     if count == 1:
#         count -= 1
#
#         max_i = 0
#         for i in range(0, start) :
#             if number[max_i] < number[i]:
#                 max_i = i
#                 # print(max_i, '최고값')
#
#         answer += number[max_i]
#
#         location = max_i+1
#         d = number[location:start]
#         k -= 1
#
#     else :
#
#         print('--------------------------', k)
#
#
#         print(d)
#         min_i = min(d)
#         print(min_i, '최소값')
#         # real_location += location
#         d += number[start]
#         k -= 1
#         if len(result) == len(number) :
#             break
#         print('a[start]:', number[start], d)
#         d.remove(min_i)
#         start += 1
#         print(d, '제거 후')
#         print(d, 'd값', start,'start')
#     print('1사이클')
#     print('----------------------------')
#     print('----------------------------')
#     l = ''.join(d)
#     result = answer+l
#
#
# print(result)