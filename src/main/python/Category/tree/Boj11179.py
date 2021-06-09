input = int(input())
def makeBin(number):
    return str(bin(number))[2:][::-1]

def deleteZero(number):
    number = list(number)
    while 1:
        if number[0] == 0:
            number.pop(0)

        if (number[0] != 0):
            return number

def cal(lst):
    count = 0
    answer = 0
    while len(lst):
        if lst[-1] == "1":
            answer += (2 ** count) * int(lst[-1])
        lst.pop()
        count += 1
    return answer


number = makeBin(input)
answer = deleteZero(number)
print(cal(answer))