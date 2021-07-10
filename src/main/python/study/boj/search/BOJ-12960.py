# 막대의 종류는 3가지
# A, B, C 각 막대에는 0개 이상의 원판
# 각 원을 움직여야 하는데 막대의 제일 위에서 제일 위로 옮겨야 한다.
# 무한 루프 ->
import sys
from collections import deque


input = sys.stdin.readline
alpha_list = deque()
alpha_count = []
abc = ['A', 'B', 'C']
visited = [0] * 3

start_number = -1e9


def find_start(alpha_list):
    global start_number
    for i in range(3):
        if len(alpha_list[i]) != 0:
            start_number = i
            return


def checkVisited(alph):
    visited[ord(alph) - ord('A')] = 1


def recoverVisited(alpha):
    visited[ord(alph) - ord('A')] = 0


for i in range(3):
    x, y = map(str, input().split())
    alpha_count.append(int(x))
    alpha_list.append(deque(y))


def checkAlpha(alpha_list):
    set_a = list(set(alpha_list[0]))
    set_b = list(set(alpha_list[1]))
    set_c = list(set(alpha_list[2]))
    flag_a = False
    flag_b = False
    flag_c = False

    for i in range(3):
        if abc[0] != set_a[0]:
            return False
    return True
    # if 'B' or 'C' not in set_a :
    #     flag_a = True
    # if 'A' or 'C' not in set_b :
    #     flag_b = True
    # if 'A' or 'B' not in set_c :
    #     flag_c = True
    #
    # return True if flag_a and flag_b and flag_c else False


print(checkAlpha(alpha_list))
q = deque()
q.append((0, alpha_list))

ans = 1e9

while 1:
    count, lst = q.popleft()
    if checkAlpha(lst):
        ans = count

    for i in range(3):
        if len(lst[i][1]) != 0:
            checkVisited(visited[i])


def dfs(count, lst):
    if checkAlpha(lst):
        return count

    for i in range(3):
        if len(lst[i][1]) != 0:
            checkVisited(lst)
            move = lst[i][1].popleft()
            for j in range(3):
                if not visited[j]:
                    lst[i][j].append(move)
                    dfs(count + 1, lst)
                    recoverVisited(lst[i][1])


print(answer)
