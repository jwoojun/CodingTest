def solution(s):
    left = right = 0
    s = list(str(s))
    for i in range(len(s)):
        if i < len(s) // 2:
            left += int(s[i])
        else:
            right += int(s[i])
    if left == right:
        return "LUCKY"
    else:
        return "READY"


print(solution(7755))
# TestCase
# 123402
# 7755
