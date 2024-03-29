from copy import deepcopy

# Get Input
#print("Enter/Paste your content. Ctrl-D or Ctrl-Z ( windows ) to save it.")

param_N, param_M , param_T = map(int, input().split())
disk_num = []
for i in range(param_N) :
    disk_num.append([int(x) for x in input().split(' ')])

params_rotate = []

for i in range(param_T) :
    params_rotate.append([int(x) for x in input().split(' ')])

# param = []
# while True:
#     try:
#         line = input()
#     except EOFError:
#         break
#     param.append(line)
# input_data = input("Input Problem! LOL \n")

# print(input_data)

# Parse Input
#Parse Input
# param = input_data.split('\n')
# param_N, param_M, param_T = [int(x) for x in param[0].split(' ')]
# disk_num = [[int(y) for y in param[x+1].split(' ')] for x in range(param_N)]
# params_rotate = [[int(y) for y in param[x+1+param_N].split(' ')] for x in range(param_T)]


def turn_disk(disk, rotate_param): # rotate_param = [xi(배수), di(방향, 0-시계, 1-반시계), ki(회전칸수)]
    temp_disk = deepcopy(disk)
    # print(temp_disk)
    shift_num = rotate_param[2] % param_M

    for i in range(len(disk) // rotate_param[0]):
        if rotate_param[1] == 0:
            for j in range(param_M):
                # print(i+1, " : ", j - shift_num, " : ", (i+1) * rotate_param[0] - 1)
                temp_disk[(i+1) * rotate_param[0] - 1][j] = disk[(i+1) * rotate_param[0] - 1][j - shift_num]
                # print(temp_disk)
        else:
            for j in range(param_M):
                # print(i+1, " : ", (j + shift_num) % param_M)
                temp_disk[(i+1) * rotate_param[0] - 1][j] = disk[(i+1) * rotate_param[0] - 1][(j + shift_num) % param_M]

    return temp_disk

def check_similar(disk):
    temp_disk = deepcopy(disk)
    disk_check = False

    for i in range(param_N):
        for j in range(param_M):
            if disk[i][j] != 0:
                if disk[i][j] == disk[i][j-1]:
                    temp_disk[i][j], temp_disk[i][j-1] = 0, 0
                    disk_check = True

                if disk[i][j] == disk[i][(j+1) % param_M]:
                    temp_disk[i][j], temp_disk[i][(j+1) % param_M] = 0, 0
                    disk_check = True

                if disk[i][j] == disk[(i+1) % param_N][j] and i+1 < param_N:
                    temp_disk[i][j], temp_disk[(i+1) % param_N][j] = 0, 0
                    disk_check = True

                if disk[i][j] == disk[i-1][j] and i-1 >= 0:
                    temp_disk[i][j], temp_disk[i-1][j] = 0, 0
                    disk_check = True
            else:
                pass

    if disk_check is False:
        disk_mean = 0
        total_num_cnt = 0
        for i in range(param_N):
            for j in range(param_M):
                disk_mean += disk[i][j]
                if disk[i][j] != 0:
                    total_num_cnt += 1

        # print('SUM : ', disk_mean, total_num_cnt)
        if total_num_cnt == 0:
            pass
        else:
            disk_mean  = disk_mean/total_num_cnt

            for i in range(param_N):
                for j in range(param_M):
                    if disk[i][j] > disk_mean and disk[i][j] != 0:
                        temp_disk[i][j] = disk[i][j] - 1
                    elif disk[i][j] < disk_mean and disk[i][j] != 0:
                        temp_disk[i][j] = disk[i][j] + 1
                    else:
                        pass

    return temp_disk

for i in range(param_T):
    disk_num = turn_disk(disk_num, params_rotate[i])
    # print('T: ', disk_num)
    disk_num = check_similar(disk_num)
    # print('C: ', disk_num)

# print(disk_num)

output_ans = 0

for i in range(param_N):
    for j in range(param_M):
        output_ans += disk_num[i][j]

print(output_ans)

# import sys
# from collections import deque
# input = sys.stdin.readline
# import heapq
#
#
#
#
# subway = ["1 2 3 4 5 6 7 8", "2 11","0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"]
#
# station = []
# for i in range(len(subway)) :
#     station.append(subway[i].split(" "))
# for k in station :
#     for i in range(len(k)) :
#         k[i] = int(k[i])
#
# for p in station :
#     print(p)
#
#
#
# def dijkstra(station, start):
#     distances = [1e9] * (len(station) + 1)
#     distances[start] = 0
#     queue = []
#     heapq.heappush(queue, [distances[start], start])
#
#     while queue :
#         current_distance, current_destination = heapq.heappop(queue)
#
#         if distances[current_destination] < current_distance:
#             continue
#         for new_destination, new_distance in station[current_destination].items():
#             distance = current_distance + new_distance
#             if distance < distances[new_destination]:
#                 distances[new_destination] = distance
#                 heapq.heappush(queue, [distance, new_destination])
#     return distances
# dijkstra(station,1)
#
#
#
#
# # import sys
# # from collections import deque
# #
# # input = sys.stdin.readline
# #
# # N = int(input())
# # dp_table = [0] * (N + 1)
# # T, P = [], []
# # for i in range(N):
# #     t, p = map(int, input().split())
# #     T.append(t)
# #     P.append(p)
# #
# # max_value = 0
# #
# # # dp_table -> i 번째까지 시행했을 때 얻을 수 있는 금액의 최대 크기
# # for i in range(N - 1, -1, -1):
# #     time = T[i] + i
# #     if time <= N:
# #         dp_table[i] = max(max_value, P[i] + dp_table[time])
# #         max_value = dp_table[i]
# #     else:
# #         dp_table[i] = max_value
# # print(max_value)
#
#
#
# # p = []
# # for itm in result:
# #     if itm[0] <= 1:
# #         p.append(itm[1])
# #
# # print(max(p))
#
#
# # N, M = map(int, input().split())
# # board = []
# # for i in range(N):
# #     board.append(list(map(int, input().split())))
# #
# # cost = copy.deepcopy(board)
# # dx= [0,0,1,-1]
# # dy=[1,-1,0,0]
# #
# # def bfs(i,j ) :
# #     board[i][j] = 1
# #     q = deque()
# #     q.append((i,j))
# #
# #     while q :
# #         x, y = q.popleft()
# #         for i in range(4) :
# #             next_x = x + dx[i]
# #             next_y = y + dy[i]
# #             if 0<= next_x<N and 0<= next_y <M :
# #                 if cost[next_x][next_y] == 1 :
# #                     cost[next_x][next_y] = cost[x][y] +1
# #                     q.append((next_x,next_y))
# #
# #     return cost[N-1][M-1]
# #
# # print(bfs(0,0))
# # 5 6
# # 1 0 1 0 1 0
# # 1 1 1 1 1 1
# # 0 0 0 0 0 1
# # 1 1 1 1 1 1
# # 1 1 1 1 1 1
#
#
# # 4 4
# # 1 1 0
# # 1 1 1 1
# # 1 0 0 1
# # 1 1 0 1
# # 1 1 1 1
#
# # N, K = map(int, input().split())
# # alpha_lst = []
# # learn = [False] * 26
# #
# # if K < 5 or K == 26 :
# #     print(0 if K<5 else N)
# #     exit()
#
#
# # 1
# # N, M, K= map(int,input().split())
# # numbers = list(map(int,input().split()))
# # numbers.sort()
# # biggest = numbers[-1]
# # second_biggest = numbers[-2]
# # one_set = M//(K+1)
# # namuzi = M%(K+1)
#
#
# # a= biggest*(K)+second_biggest
# # print(a*one_set+namuzi*biggest)
#
#
# # from math import factorial
# # N=int(input())
# #
# # dp_table = [0]*101
# # dp_table[2] = 1
# #
# #
# # for i in range(N) :
# #     number = int(input())
# #     if number % 2 != 0 :
# #         print(0)
# #     else :
# #         if number == 2 :
# #             print(1)
# #         else :
# #             k = number // 2
# #             dp_table[2*k] = dp_table[k] +3
# #
# # print(dp_table)
#
#
# #
#
# # t=2
# # dp =[[[-1 for _ in range(t) ]for _ in range(t)] for _ in range(t)]
# # for i in dp :
# #     print(i)
# #
# # print(dp[0][0][1])
# # input = sys.stdin.readline
# #
# # N = int(input())
# # station = []
# #
# # for i in range(N):
# #     a, b = map(int, input().split())
# #     count = 0
# #     station.append((a, b, count))
# #
# # min_value = 1e9
# # L, P = map(int, input().split())
# #
# # q = deque()
# # q.append((0, P, 0))
# # print(q)
# # start_distance = 0
# # start_fuel = P
# # number = 0
# # while q:
# #     distance, fuel, cnt = q.popleft()
# #     print(q)
# #     if cnt == N :
# #         break
# #     if fuel <= 0:
# #         continue
# #
# #     if distance >= L or cnt == N:
# #         min_value = min(cnt, min_value)
# #         print(min_value)
# #
# #     q.append((distance + station[number][0], fuel - station[number][0] + station[number][1], cnt + 1))
# #     q.append((distance + station[number][0], fuel - station[number][0], cnt + 1))
# #
# # print(min_value)
# # N = int(input())
# # under_zero = []
# # over_zero = []
# # mid = []
# # for i in range(N):
# #     number = int(input())
# #     if number <= 0:
# #         under_zero.append(number)
# #     elif number ==1 :
# #         mid.append(1)
# #     else:
# #         over_zero.append(number)
# #
# # under_zero.sort()
# # over_zero.sort(reverse=True)
# # one = []
# # answer = 0
# # if len(under_zero)%2 == 0 :
# #     for i in range(0, len(under_zero)-1, 2) :
# #         answer += under_zero[i] * under_zero[i+1]
# #
# # else :
# #     for i in range(0, len(under_zero)-1, 2) :
# #         answer += under_zero[i] * under_zero[i+1]
# #     answer += under_zero[-1]
# #
# # if len(over_zero)%2 == 0 :
# #     for i in range(0, len(over_zero)-1, 2) :
# #         answer += over_zero[i] * over_zero[i+1]
# #
# # else :
# #     for i in range(0, len(over_zero)-1, 2) :
# #         answer += over_zero[i] * over_zero[i+1]
# #     answer += over_zero[-1]
# #
# #
# # answer += sum(mid)
# # print(answer)
#
#
# # N = int(input())
# # numbers= []
# # for i in range(2,N+1) :
# #     numbers.append(i)
# #
# # def prime_number(N) :
# #
# #     for i in range(2, int(math.sqrt(N))+1) :
# #         j = 2
# #         while i * j < N+1 :
# #             if i*j in numbers :
# #                 numbers.remove(i*j)
# #
# #             j+=1
# # prime_number(N)
# # count= 0
# # subSum = end = 0
# # print(numbers)
# # for start in range(len(numbers)) :
# #
# #     while subSum< N and end < len(numbers) :
# #         print(subSum,count)
# #         subSum+=numbers[end]
# #         end +=1
# #
# #     if subSum == N :
# #         count+=1
# #     subSum -= numbers[start]
# # print(count)
#
#
# # input = sys.stdin.readline
# # N = int(input())
# # numbers = list(map(int, input().split()))
# #
# #
# # visited = [True]+[False]*(N-1)
# #
# #
# # def visitable(position) :
# #     return position< N and not visited[position]
# #
# # def bfs(start, start_count) :
# #
# #     q = deque()
# #     q.append((start, start_count))
# #
# #     while q :
# #         position, count = q.popleft()
# #         if position == N-1 :
# #             return count
# #
# #         for move in range(1, numbers[position]+1) :
# #             next_position = position + move
# #             if visitable(next_position) :
# #                 visited[next_position] = True
# #                 q.append((next_position, count+1))
# #
# #     return -1
# #
# # print(bfs(0,0))
#
#
# # def test(a, b) :
# #     q=deque()
# #     q.append((a,b))
# #     print(a,b,'start')
# #     # 1,2
# #     # 2, 2
# #     # 3, 3
# #     # 4, 4
# #     while q :
# #         a, b = q.popleft()
# #         if b == 5 :
# #             return b
# #         a+=1
# #         q.append((a, b+1))
# #
# #         print(a,b, 'middle')
# #     print(a,b, 'end')
# #     return
# #
# #
# #
# # def test2(x, y) :
# #     q=deque()
# #     q.append((x,y))
# #     print(x,y,'start')
# #     # 1,2
# #     #
# #     while q :
# #         a, b = q.popleft()
# #         if b == 5 :
# #             return b
# #         a+=1
# #         q.append((a, b+1))
# #
# #         print(a,b, 'middle')
# #     print(x,y, 'end')
# #     return
# # print('-----------')
# # print(test(1,2))
# # print('-----------')
# # print(test2(1,2))
#
#
# # input()
# # A = list(map(int, input().split()))
# # dp = []
#
# # for i in A:
# #     k = bisect_left(dp, i)
# #     print(dp,k)
# #     if len(dp) <= k:
# #         dp.append(i)
# #     else:
# #         dp[k] = i
# #
# # print(len(dp))
# # print(dp)
#
#
# # import sys
# #
# # input = sys.stdin.readline
# #
# # N = int(input())
# # max_result = -1e9
# # min_result = 1e9
# # numbers = list(map(int, input().split()))
# # plus, minus, multi, div = map(int, input().split())
# # op_count = plus + minus + multi + div
# # result = 0
# #
# #
# # def dfs(result, count, plus, minus, multi, div):
# #     global max_result, min_result
# #     if count - 1 == op_count:
# #         max_result = max(result, max_result)
# #         min_result = min(result, min_result)
# #         return
# #     if plus > 0:
# #         dfs(result + numbers[count], count + 1, plus - 1, minus, multi, div)
# #     if minus > 0:
# #         dfs(result - numbers[count], count + 1, plus, minus - 1, multi, div)
# #     if multi > 0:
# #         dfs(result * numbers[count], count + 1, plus, minus, multi - 1, div)
# #     if div > 0:
# #         dfs(int(result / numbers[count]), count + 1, plus, minus, multi, div - 1)
# #
# #
# # dfs(numbers[0], 1, plus, minus, multi, div)
# # print(max_result)
# # print(min_result)
#
# # N =  int(input())
# # numbers = list(map(int,input().split()))
# # operation_count = list(map(int,input().split()))
#
#
# # a = -3
# # b = 2
# #
# # print(a//b)
# # print('------')
# #
# # a = -3
# # b = 2
# # print(-abs(a)//2)
# #
# #
