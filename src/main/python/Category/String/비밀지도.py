def solution(n, arr1, arr2):
    answer = []
    for i, j in zip(arr1, arr2):
        tmp = str(bin(i | j))[2:]
        tmp = tmp.rjust(n, "0")
        tmp = tmp.replace("1", "#")
        tmp = tmp.replace("0", " ")
        answer.append(tmp)
    return answer
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]
print(solution(5, arr1, arr2))


# print("0"*3)
a ="# "
b = "#"
print(a+b)
