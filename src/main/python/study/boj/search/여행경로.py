from collections import defaultdict, deque

# tickets= [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
tickets = [["ICN", "A"], ["ICN", "B"], ["B", "ICN"]]
ans = []

def makeList(tickets, path):
    for i in range(len(tickets)):
        path[tickets[i][0]].append(tickets[i][1])
    return path


def sorting(dic):
    for i in dic:
        dic[i].sort()


def bfs(path):
    start = 'ICN'
    q = deque()
    ans.append(start)
    while q:
        if len(path[start]) == 0 :
            break
        for i in range(0, len(path[start])):
            if path[start][i] in path:
                arrive = path[start].pop(i)
                ans.append(arrive)
                start = arrive

    return ans


def solution(tickets):
    path = defaultdict(list)
    global ans
    path = makeList(tickets, path)
    sorting(path)
    answer = bfs(path)
    return answer
print(solution(tickets))


#
#
# def makeList(tickets, path) :
#     for i in range(len(tickets)) :
#         path[tickets[i][0]].append(tickets[i][1])
#     return path
# def sorting(dic) :
#     for i in dic :
#         dic[i].sort()
#
#
# path = makeList(tickets, path)
# sorting(path)
# print(path,"=================")
#
# answer = []
#
# def bfs(path) :
#     start = 'ICN'
#     answer.append(start)
#     while 1 :
#         if len(path[start]) == 0 :
#             break
#         arrive = path[start].pop(0)
#         answer.append(arrive)
#         start = arrive
#
#     return answer
# print(bfs(path))


# print(county[0])

# def collectPath(tickets) :



















# def solution(tickets):
#     routes = init_graph(tickets)
#     for i in routes:
#         routes[i].sort()
#     answer = dfs(routes)
#     return answer
#
#
# def init_graph(tickets):
#     routes = defaultdict(list)
#     for key, value in tickets:
#         routes[key].append(value)
#     return routes
#
#
# def dfs(routes):
#     stack = ["ICN"]
#     path = []
#     while stack:
#         top = stack[-1]
#         if len(routes[top]) == 0 or top not in routes:
#             path.append(stack.pop())
#         else:
#             stack.append(routes[top].pop(0))
#
#     return path[::-1]
