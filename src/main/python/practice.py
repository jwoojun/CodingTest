import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))

visited = [True] + [False] * N


def bfs(start, result):
    q = deque()
    q.append((start, result))
    while q:
        index, count = q.popleft()
        if index + 1 == N:
            return count

        for i in range(numbers[index] + 1):
            next_index = index+i
            if next_index < N and not visited[next_index]:
                visited[next_index] = True
                q.append((next_index, count + 1))

    return -1


print(bfs(0, 0))
