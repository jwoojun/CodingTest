from collections import deque


def solution(numbers, target):
    answer = 0
    q = deque()
    q.append((0, 0))
    while q:
        compile_sum, index = q.popleft()

        if index == len(numbers):
            if compile_sum == target:
                answer += 1
        else:
            q.append((compile_sum + numbers[index], index + 1))
            q.append((compile_sum - numbers[index], index + 1))

    return answer


def solution(numbers, target):
    answer = [0]
    for i in numbers:
        sub = []
        for j in answer:
            sub.append(j + i)
            sub.append(j - i)
        answer = sub

    count = answer.count(target)
    return count


# numbers = [1, 1, 1, 1, 1]
# target = 3
# print(solution(numbers, target))
# https://namhandong.tistory.com/143