# SW Expert Academy
def solution(n) :
    for j in range(len(n)) :
        if j !=0 and n[0:j] == n[j:j+j] :
            return j

N = int(input())
for i in range(N) :
    a = input()
    answer = solution(a)
    print(f'#{i+1} {answer}')


# 출처 : https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
