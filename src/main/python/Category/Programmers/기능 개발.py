# 기능개발
from collections import deque
import copy


def solution(progresses, speeds):
    progresses, speeds = deque(progresses), deque(speeds)
    answer, sub = [], []

    # 한 번에 progresses[0]을 100으로 만들기 위한 횟수 계산. 이때 speed가 1일때, 아닐때 차이 존재
    while len(progresses) > 0:
        if speeds[0] == 1:
            time = ((100 - progresses[0]) // speeds[0])

        else:
            time = ((100 - progresses[0]) // speeds[0]) + 1

        # 굳이 한개라면 초 계산해줄 필요도 없기 때문에 끝
        if len(progresses) == 1:
            answer.append(1)
            return answer

        # 한 번의 for문으로 progresses[0]을 100으로 만듬
        for i in range(len(progresses)):
            progresses[i] += (time * speeds[i])

        # 원소를 제거하면서 돌리기(원래 원소는 제거하면서 deep카피로 순서는 유지)
        a = copy.deepcopy(progresses)
        for j in range(len(a)):
            if a[j] >= 100:
                sub.append(progresses.popleft())
                speeds.popleft()

            else:
                break

        answer.append(len(sub))
        sub = []

    return list(answer)