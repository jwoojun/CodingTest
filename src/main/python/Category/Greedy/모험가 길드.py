def solution (n, group) :
    group.sort()
    answer = count = 0
    for i in group:
        count += 1
        if count >= i:
            answer += 1
            count = 0

    return answer

n = int(input())
group = list(map(int, input().split()))