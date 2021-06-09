from collections import deque


def solution(people, limit):
    # 오름차순으로 정렬 후 deque로 만든다.
    people.sort()
    people = deque(people)

    count = 0
    while (len(people) != 0):
        # stack 초기화
        stack = deque()

        stack.append(people.pop())

        if (len(people) == 0):
            count += 1
            break

        a = stack[0]

        i = 0
        while (len(people) != 0):
            if a + people[i] <= limit:
                a += people.popleft()
            else:
                break

        count += 1

    return count