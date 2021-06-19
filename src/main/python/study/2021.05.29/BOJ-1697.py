import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
visited = [False] * 100001


def bfs(v):
    answer = 0
    q = deque([[v, answer]])
    while q:
        v = q.popleft()
        number, answer = v[0], v[1]
        if not visited[number]:
            visited[number] = True
            if number == K:
                return answer
            answer += 1
            if (number * 2) <= 100000:
                q.append([number * 2, answer])
            if (number + 1) <= 100000:
                q.append([number + 1, answer])
            if (number - 1) <= 100000:
                q.append([number - 1, answer])
    return answer


print(bfs(N))
