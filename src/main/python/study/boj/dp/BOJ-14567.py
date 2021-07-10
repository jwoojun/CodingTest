import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
course = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)
dp = [0 for _ in range(N + 1)]
for i in range(M):
    subjectA, subjectB = map(int, input().split())
    course[subjectA].append(subjectB)
    indegree[subjectB] += 1

q = deque([])
for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)
        dp[i] = 1

while q:
    subject = q.popleft()
    for i in course[subject]:
        indegree[i] -= 1
        dp[i] = max(dp[subject] + 1, dp[i])
        if indegree[i] == 0:
            q.append(i)
print(*dp[1:])
