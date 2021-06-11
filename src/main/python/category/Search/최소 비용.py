# def search() :
#     dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
#     NUM = 999999
#     visit = [[NUM]*N for _ in range(N)]
#     visit[0][0] = 0
#     que = []
#     que.append([0, 0])
#
#     while que :
#         x, y = que.pop()
#         for i in range(4) :
#             move_x, move_y = x+dx[i], y+dy[i]
#             if ( 0<= move_x < N) and (0 <= move_y < N) :
#                 distance = 1
#                 if Map[move_x][move_y] > Map[x][y] :
#                     distance += (Map[move_x][move_y] - Map[x][y])
#                 if visit[move_x][move_y] > visit[x][y] + distance :
#                     visit[move_x][move_y] = visit[x][y] + distance
#                     que.append([move_x, move_y])
#                 print(visit)
#     return visit[N-1][N-1]
#
#
# for i in range(int(input())) :
#     N = int(input())
#     Map = [list(map(int, input().split())) for _ in range(N)]
#     print(f'#{i+1} {search()}')


# memo = [0]*5000
# count = 0
# def m(n) :
#     global count
#     memo[0], memo[1], memo[2] = 0, 1, 1
#     if n==1 : return memo[1]
#     if n==2 : return memo[2]
#     memo[n] = m(n-1) + m(n-2)
#     count += 1
#     print(count)
#     return memo[n]


def fastFib(n, memo):
    if not n in memo: memo[n] = fastFib(n-1, memo) + fastFib(n-2, memo)
    return memo[n]

def fibonacci(n):
    memo = {0:1, 1:1}
    return fastFib(n, memo)
print(fibonacci(100))

from functools import lru_cache

a = lru_cache(10, int)
print(a, "여기")









def solution(n) :
    N = [0]*(n+1)
    N[0], N[1] = 0, 1
    for i in range(2, n+1) :
        N[i] = N[i-1]+ N[i-2]

    return N[n]
print(solution(50))







# def fibo(n) :
#     if n==1 : return 1
#     if n==2 : return 1
#     return fibo(n-2) + fibo(n-1)
#
# print(fibo(50))