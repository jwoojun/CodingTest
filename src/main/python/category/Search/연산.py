from collections import deque
TC = int(input())
for i in range(TC):
    N, M = map(int, input().split())
    visited, queue = [False]*1000001, deque()
    queue.append((N, 0))
    visited[N] = True
    q, ans = queue.popleft()
    if q == M:
        break
    print(q, ans)
    while True:

        check = q + 1
        print(q)
        if not visited[check] and 0 < check <= 1000000:
            queue.append((check, ans + 1))
            visited[check] = True




        check = q - 1
        if not visited[check] and 0 < check <= 1000000:
            queue.append((check, ans + 1))
            visited[check] = True


        check = q * 2
        if not visited[check] and 0 < check <= 1000000:
            queue.append((check, ans + 1))
            visited[check] = True



        check = q - 10
        if not visited[check] and 0 < check <= 1000000:
            queue.append((check, ans + 1))
            visited[check] = True
            q = queue[0][0]
            queue.popleft()
            if q == M:
                break


    print("#{} {}".format(i + 1, ans))