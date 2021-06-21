from collections import deque


def solution(numbers, target):
    answer = count = 0
    q = deque([(0, count)])

    while q:
        sum_, count = q.popleft()
        if count == len(numbers):
            if sum_ == target:
                answer += 1

        else:
            q.append((sum_+numbers[count], count+1))
            q.append((sum_-numbers[count], count+1))

    return answer

print(solution([1,1,1,1,1], 3))
