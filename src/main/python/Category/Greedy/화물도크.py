N = int(input())

for i in range(N) :
    M = int(input())
    lst = []

    for j in range(M) :
        lst.append(list(map(int, input().split())))

    lst.sort(key=lambda e:e[1])
    answer, work_end = 0, 0

    while lst :
        start_time, end_time = lst.pop(0)
        if start_time >= work_end :
            answer += 1
            work_end = end_time
    print(f'#{i+1} {answer}')