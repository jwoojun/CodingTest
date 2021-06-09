import sys

input = sys.stdin.readline

N = int(input())
distance_and_fuel = []

for i in range(N):
    a, b = map(int, input().split())
    distance_and_fuel.append((a, b))
# distance_and_fuel = [ (4, 4),(5, 2), (11, 5), (15, 10) ]

L, P = map(int, input().split())
# L, P = 25, 10

# 정답 count
count = 0

# 움직인 거리
move_distance = 0

# 연료배열
fuel = []

# 거리 [4, 1, 6, 4]
new_distance = [distance_and_fuel[0][0]]

# fuel = [4, 2, 5, 10]
for i in range(len(distance_and_fuel)):
    fuel.append(distance_and_fuel[i][1])

for i in range(len(distance_and_fuel) - 1):
    new_distance.append(distance_and_fuel[i + 1][0] - distance_and_fuel[i][0])

i = 0
while (move_distance < L and P > 0 and i < len(fuel) - 1):

    P -= new_distance[i]
    if (i == 0 and P <= 0):
        break;
    move_distance += new_distance[i]

    P -= new_distance[i + 1]
    if (P > 0):
        P += new_distance[i + 1]

    else:
        P += new_distance[i + 1]
        P += fuel[i]
        count += 1

    i += 1

if (count == 0):
    print(-1)
else:
    print(count+1)
