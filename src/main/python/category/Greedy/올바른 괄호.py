# 풀이1
def solution(s):
    if len(s) % 2 != 0: return False
    answer = []
    startBracket, endBracket = "(", ")"
    setBracekt = {"(": ")", ")": "("}

    for i in range(len(s)):
        if s[i] == startBracket:
            answer.append(s[i])
        else:
            if len(answer) == 0: return False
            if answer[-1] == setBracekt[s[i]]:
                answer.pop()
            else:
                return False

    if len(answer) != 0:
        return False
    else:
        return True



# 풀이2
def is_pair(s):
    # 함수를 완성하세요
    x = 0
    for w in s:
        if x < 0:
            break
        x = x+1 if w=="(" else x-1 if w==")" else x
    return x==0



# 풀이3
def solution(s):
    list_s=s
    cnt=0
    answer = True
    for a in range(len(list_s)):
        if list_s[a]=="(":
            cnt+=1
        else:
            cnt-=1
            if cnt<0:
                return False
    if cnt!=0:
        return False
    return True
