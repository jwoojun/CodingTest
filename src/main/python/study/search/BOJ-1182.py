import sys
from collections import deque

input = sys.stdin.readline

N, S = map(int, input().split())
numbers = list(map(int, input().split()))
interval_sum = []


def bfs(numbers):
    answer = 0
    q = deque([[0, 0]])

    while q:
        sum_, count = q.popleft()

        # count가 리스트의 길이를 초과할 수도 있기 때문에 >=로 설정
        if count >= len(numbers):
            if sum_ == S:
                answer += 1
        else :
            # 자신을 포함하는 경우 - 다음 수를 더한다.
            q.append([sum_ + numbers[count], count + 1])

            # 자신을 포함하지 않는 경우
            q.append([sum_, count + 1])

    return answer

if S :
    print(bfs(numbers))

# S가 0인 경우
else :
    print(bfs(numbers)-1)