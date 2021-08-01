def solution(N, stages):
    stages.sort()
    answer = []
    total = len(stages)
    for i in range(1, N + 1):
        count = 0
        for j in range(0, len(stages)):
            if stages[j] == i:
                count += 1
            if stages[j] > i :
                break
        if total == 0 :
            answer.append((i,0))
            continue
        a, b = i, count / total
        answer.append((a, b))
        total -= count
    real_answer = []
    k = sorted(answer, key=lambda x: -x[1])
    for i in range(len(k)):
        real_answer.append(k[i][0])
    return real_answer
stages=[2,1,2,4,2,4,3,3]
N= 5
print(solution(N,stages))