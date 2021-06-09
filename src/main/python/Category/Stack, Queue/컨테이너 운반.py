from collections import deque

def solution(truck_weight, load_weight) :
    truck_weight, load_weight = deque(sorted(truck_weight, reverse=True)), deque(sorted(load_weight, reverse=True))
    answer = []
    while truck_weight and load_weight :
        if load_weight[0] <= truck_weight[0]:
            truck_weight.popleft()
            answer.append(load_weight.popleft())

        else:
            load_weight.popleft()

    return sum(answer)


N = int(input())
for i in range(N) :
    M, N = map(int, input().split())
    load_weight = list(map(int, input().split()))
    truck_weight = list(map(int, input().split()))
    print(f'#{i+1} {solution(truck_weight, load_weight)}')