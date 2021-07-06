N, C = list(map(int, input().split(' ')))

house_address = []
for _ in range(N):
    house_address.append(int(input()))

house_address.sort()

start_address = house_address[1] - house_address[0]
