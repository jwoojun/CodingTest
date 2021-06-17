# 네트워크 연결
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
connection = [[] for i in range(M+1)]
for i in range(1, M + 1):
    a, b, c = map(int, input().split())
    connection[a].append((c, b))

connection = sorted(connection, key=lambda x:x[0][0])
print(connection)