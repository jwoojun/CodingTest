import string
def solution(name) :
    # 정답, index 번호
    answer = n = 0

    # 알파벳 배열
    alpha = list(string.ascii_uppercase)

    # 시작점, 끝점
    startNumber, finalNumber = 0, 25

    # 직전 항 초기 0
    beforLocation = 0

    # 전체 길이
    count = len(name)
    print(alpha)

    while (n < count):
        print(name[n])
        currentLocation = alpha.index(name[n])
        indirectDistance = (abs(finalNumber - currentLocation)+1)
        directDistance = abs(currentLocation - beforLocation)

        if indirectDistance < directDistance :
            answer += finalNumber-currentLocation +2
            beforLocation = alpha.index(name[n])


        else :
            answer += directDistance
            beforLocation = alpha.index(name[n])


        n += 1
        print(answer)
    return answer

dic={}
clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
# clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
category = {}
answer = 1
for i in range(len(clothes)) :
    if clothes[i][1] in dic :
        dic[clothes[i][1]].append(clothes[i][0])

    else :
        dic[clothes[i][1]] = [clothes[i][0]]
for i in dic :
    print(dic[i])
    answer *= (len(dic[i])+1)

print(answer-1)