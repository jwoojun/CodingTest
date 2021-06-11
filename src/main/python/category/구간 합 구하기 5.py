import sys

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[0] * (N + 1)]
position = [[0] * (N + 1)]
sum_compile = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    graph.append([0] + list(map(int, input().split())))

for i in range(1, N + 1):
    position.append([0] + list(map(int, input().split())))
answer = 0
asw = []
# for i in range(1, len(position)+1) :
#     position[i][]
#
# for i in range(1, N) :
#     for j in range(1, N+1) :
#         sum_compile[i][j+1] = sum_compile[i][j]

# for i in range(1, len(position)) :


for i in graph:
    print(i)
print("======")
for j in position:
    print(j)

for i in range(1, N):
    line = position[i][1]
    for j in range(1, N + 1):
        # position[i+1][j] =
        sum_compile[i][j] = line + sum_compile[i - 1][j]
        print(sum_compile)