def main():
    num = int(input())
    array = list(map(int, input().split()))
    array.sort()
    answer, nb = [], 0
    while (nb<len(array)):
        if len(answer) == 0:
            answer.append(array[nb])

        elif array[nb] > answer[-1]:
            answer.append(array[nb])
        nb += 1

        if len(answer) == 3:
            return "YES"

    return "NO"


# 출처 : 구름에듀