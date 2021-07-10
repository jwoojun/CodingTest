import re
def solution(s):
    s = re.findall("\d+",s)
    ans, answer = {}, []
    for i in s : ans[i] = 0
    for i in s : ans[i] += 1
    ans = sorted(ans.items(), reverse = True, key = lambda x : x[1])
    for i in range(len(ans)) : answer.append(int(ans[i][0]))
    return answer