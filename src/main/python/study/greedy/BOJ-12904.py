import copy

S = input()
T = input()


def deleteA(word):
    return word[:len(word) - 1]


def deleteBandReverse(word):
    word = word[:len(word) - 1]
    word = word[::-1]
    return word


word = copy.deepcopy(T)

for i in range(len(T)):
    if word[-1] == 'A':
        word = deleteA(word)
    else:
        word = deleteBandReverse(word)
    if word == S :
        print(1)
        exit()

print(0)
