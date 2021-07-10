from collections import deque


def solution(priorities, location):
    priorities, count = deque(priorities), 0

    while True:
        a = max(priorities)
        if priorities[0] == a:
            if location == 0:
                priorities.popleft()
                count += 1
                return count

            elif location != 0:
                priorities.popleft()
                count += 1
                location -= 1
                if location < 0:
                    location = len(priorities) - 1

        else:
            priorities.append(priorities.popleft())
            location -= 1
            if location < 0:
                location = len(priorities) - 1