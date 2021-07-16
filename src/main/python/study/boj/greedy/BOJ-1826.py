import sys
import heapq
station = []
N=int(input())
for _ in range(N) :
    a, b = map(int,input().split())
    heapq.heapush(station, (a, -b))


town_distance, gas = map(int,input(), split())

if town_distance <= gas :
    print(0)
    exit()

answer= 0
gas_heap = []
currnet_position = 0

while station :
    info = gas_station[0]
    if info[0] - currnet_position <= gas :
        distance, gas = heapq.heapop(station)
        heapq.heapush(station, (gas, distance))

    else :
        break

if gas_heap :
