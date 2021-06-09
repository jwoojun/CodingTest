from string import ascii_lowercase
alp = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "_", "."]

lst = list(ascii_lowercase)
alphabet = alp + lst

# 1 -> 바로 사용
def makeLower(str):
    return str.lower()


def deleteM(str):
    global alphabet
    alpha = ""
    for i in range(len(str)):
        if (str[i] in alphabet) :
            alpha += str[i]
    return alpha

# 3
def doubleDot(str):
    alpha = " "
    for i in range(len(str)):
        if str[i] == ".":
            if alpha[-1] != ".":
                alpha += str[i]
        else:
            alpha += str[i]
    return alpha.lstrip()


# 4
def deleteStartEndDot(str):
    lst = list(str)
    if len(lst) != 0 and lst[0] == ".":
        lst.pop(0)
    if len(lst) != 0 and lst[-1] == ".":
        lst.pop()
    return "".join(lst)

# 5
def blankAlpha(str):
    if len(str) == 0:
        return (str + "a")
    return str

# 6
def over16Alpha(str):
    if len(str) >= 16:
        str = str[:15]
    if str[-1] == ".":
        str = str[:-1]
    return str


# 7
def under2Alph(str) :
    if len(str) <= 2 :
        plus = str[-1]
        while len(str) <3 :
            str += plus
    return str


def solution(new_id):
    answer = makeLower(new_id)
    answer2 = deleteM(answer)
    answer3 = doubleDot(answer2)
    answer4 = deleteStartEndDot(answer3)
    answer5 = blankAlpha(answer4)
    answer6 = over16Alpha(answer5)
    answer7 = under2Alph(answer6)
    return answer7