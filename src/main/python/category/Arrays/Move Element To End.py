def moveElementToEnd(array, toMove):
    answer = notAnswer = []
    count = 0
    for i in range(len(array)):
        if array[i] != toMove:  notAnswer.append(array[i])
        else:
            count += 1
    answer.extend([toMove] * count)
    return answer



# a = 99999
# tes = [1,2,2, 4, 5]
# import copy
# answer = []
# notanswer = []
# test = copy.deepcopy(tes)
# count = 0
# for i in range(len(tes)) :
#     if test[i] != 2 :
#         answer.append(test[i])
#     else :
#         count += 1
#
# answer.extend([2]*count)
# print(answer)
