import sys
N, C = map(int, input().split(" "))
houses = [int(sys.stdin.readline()) for _ in range(N)]
houses.sort()


def router_install(distance) :
    current_house = houses[0]
    count = 1
    for i in range(1, N) :
        if current_house + distance <= houses[i] :
            count += 1
            current_house = houses[i]
    return count

ans = 0


start, end = 1, houses[-1] - houses[0]

while (start<=end) :
    mid = (start+end)//2
    if(router_install(mid) >= C) :
        ans = mid
        start = mid+1
    else :
        end = mid -1
print(ans)