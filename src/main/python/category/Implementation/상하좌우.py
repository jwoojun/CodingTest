# 상하좌우
def solution(lst) :
    x, y = 1, 1
    move_types = ['R', 'L', 'D', 'U']
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for i in plans :
        for j in range(len(move_types)) :
            if i == move_types[j] :
                nx = x + dx[j]
                ny = y + dy[j]

        if nx <1 or ny < 1 or nx > n or ny > n :
            continue

        x, y = nx, ny

    return x, y


n = int(input())
plans = list(map(str, input().split()))


# 출처 : 이것이 코딩테스트다(p111)