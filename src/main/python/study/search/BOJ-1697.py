from collections import deque

N, K = map(int, input().split())
visited = [False] * 100001


def bfs(number):
    count = 0
    q = deque([[number, count]])

    while q:
        number, count = q.popleft()
        if not visited[number]:
            visited[number] = True
            if number == K:
                return count
            count += 1
            if (number * 2 <= 100000):
                q.append([number * 2, count])
            if (number + 1 <= 100000):
                q.append([number + 1, count])
            if (number - 1 >= 0):
                q.append([number - 1, count])
    return count

print(bfs(N))