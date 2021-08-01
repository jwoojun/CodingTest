# 재귀함수로 이진탐색
# L : 리스트 / x : 구하는 원소 / l은 시작점, u는 끝점
def solution(L, x, l, u):
    if l > u :
        return -1
    mid = (l + u) // 2
    if x == L[mid]:
        return mid
    elif x < L[mid]:
        return solution(L, x, l, mid-1)


    else:
        return solution(L, x, mid+1, u)