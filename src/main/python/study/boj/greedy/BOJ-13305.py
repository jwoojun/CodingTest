import sys
input = sys.stdin.readline

N = int(input())
roads = list(map(int, input().split()))
cities = list(map(int,input().split()))

min_value = cities[0]
answer = 0
for i in range(N-1) :
    if cities[i] < min_value :
        min_value = cities[i]
    answer += (min_value*roads[i])
print(answer)





