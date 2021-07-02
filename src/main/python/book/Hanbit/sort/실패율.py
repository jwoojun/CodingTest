def solution(N, stages):
    stages.sort()
    answer = []
    fail = [0] * (501)
    for i in stages:
        if i < N + 1:
            fail[i] += 1
            continue

    total = len(stages)
    for i in range(1, N + 1):
        if total != 0:
            if fail[i] == 0:
                answer.append((i, 0))
            else:
                answer.append((i, fail[i] / total))
                total -= fail[i]

        else:
            answer.append((i, 0))

    answer.sort(key=lambda x: (-x[1], x[0]))
    ans = []
    for i in range(len(answer)):
        ans.append(answer[i][0])

    return ans


# return list(sorted(a, key=lambda x: a[x], reverse=True))

# stages = [2,1,2,6,2,4,3,3]
stages = [4, 4, 4, 4, 4]
# stages = [2,2,2,3,4,5]
# stages = [2,1,2,4,2,4,3,3]
N = 4
print(solution(N, stages))
