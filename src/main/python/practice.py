import sys

input = sys.stdin.readline

N, M, L = map(int, input().split())
stations = list(map(int, input().split()))
stations.append(0)
stations.append(L - 1)
stations.sort()
start = 0
end = stations[-2]
answer = -1e9
while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in range(1, len(stations)):
        if stations[i] - stations[i - 1] > mid:
            count += (stations[i] - stations[i - 1] - 1) // mid



    if count > M:
        start = mid + 1
    
    else:
        answer = mid
        end = mid - 1
    print(start, end, count,answer)
print(answer)



