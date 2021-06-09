# 갯수가 얼마 되지 않기 때문에 완전탐색 활용.
def solution(n) :
    count = 0
    for i in range(n + 1):
        for j in range(60):
            for k in range(60):
                if '3' in str(i) or '3' in str(j) or '3' in str(k):
                    count += 1
    return count

n = int(input())
print(solution(n))