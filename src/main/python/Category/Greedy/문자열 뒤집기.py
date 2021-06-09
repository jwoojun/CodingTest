def solution() :
    data = input()
    count, count1 = 0, 0
    if data[0] == "0":count += 1
    else:count1 += 1

    for i in range(len(data) - 1):
        if data[i] != data[i + 1]:
            if data[i + 1] == 0:count += 1
            else:count1 += 1
    return min(count, count1)



