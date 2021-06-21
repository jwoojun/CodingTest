def solution(n, computers):
    visited = [False] * (n)
    answer = 0
    for i in range(n):
        # 방문하지 않았을 경우
        if not visited[i]:
            # 탐색
            dfs(n, i, visited, computers)
            # 한 번의 탐색으로 노드들을 이을 수 있기 때문에 탐색이 끝났을 경우 +1을 해준다.
            answer += 1

    return answer


def dfs(n, i, visited, computers):
    visited[i] = True
    for j in range(n):
        # 자기자신을 탐색할 수 있는 경우의 수는 없기 때문에 i!=j
        if computers[i][j] == 1 and i != j:
            if not visited[j]:
                dfs(n, j, visited, computers)
