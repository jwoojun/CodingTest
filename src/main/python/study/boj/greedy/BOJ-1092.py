N = int(input())
cranes = list(map(int, input().split()))
M = int(input())
boxes = list(map(int, input().split()))
boxes.sort(reverse=True)
cranes.sort(reverse=True)
ans = 0

if boxes[0] > cranes[0]:
    print(-1)
    exit()
else:
    while len(boxes) != 0:
        ans += 1

        for i in cranes:
            count = 0
            for j in range(len(boxes)):
                if i >= boxes[j]:
                    del boxes[j]
                    break
print(ans)

# TestCase 1
# 3
# 6 8 9
# 9
# 1 2 3 4 5 6 7 8 9


# TestCase 2
# 3
# 2 4 6
# 10
# 2 4 6 6 6 6 5 5 5 1


# TestCase 23
# 3
# 2 4 6
# 5
# 6 6 6 6 6 6


# 잘못된 풀이
# N = int(input())
# cranes = list(map(int, input().split()))
# M = int(input())
# boxes = list(map(int, input().split()))
# boxes.sort(reverse=True)
# cranes.sort(reverse=True)
# answer = 0
# if boxes[0] > cranes[0]:
#     print(-1)
#     exit()
# else:
#     while len(boxes) != 0:
#         answer += 1
#         print(boxes, "시작", answer)
#         for i in cranes:

# count = 0
# while len(boxes) != 0 and count <= len(boxes):
#     print("진입", answer, count)
#     if count <= len(boxes) and i >= boxes[count-1]:
#         boxes.pop(0)
#         break
#     else:
#         count += 1
#         print(count, len(boxes))
# if count <= len(boxes) and i >= boxes[count-1] :
#     boxes.pop(count-1)
#     print(count)
#     break
# print("중간점검", answer, count, boxes)
# print('=====================')
# continue
#
#
# print(answer)
