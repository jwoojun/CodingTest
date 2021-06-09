# visited = {i: 0 for i in range(5)}
#
# lst = [[0, 2], [1, 1]]
# lst = sorted(lst, key=lambda x: x[1])
# tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]
# tickets = sorted(tickets, key=lambda x: ("ICN",x[1]))
# print(tickets)
#
# a,b  =[1,2]
# print(a,b)

def solution(tickets):
    answer = []
    n = len(tickets)
    tickets = sorted(tickets, key=lambda x: ("ICN"))
    visited = [False] * n
    start, end = tickets[0]
    answer.append(start)
    dfs(start, n, visited, tickets, answer)
    return answer


def dfs(start, n, visited, tickets, answer):
    for i in range(n):
        if (visited[i] == False) and tickets[i][0] == start:
            visited[i] = True
            end = tickets[i][1]
            answer.append(end)

            dfs(end, n, visited, tickets, answer)
print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
["ICN","SFO","ATL","ICN","ATL","SFO"]
["ICN","ATL","ICN","SFO","ATL","SFO"]
