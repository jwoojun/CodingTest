# 왕실의 나이트
def solution(text):
    row = int(text[1])
    column = int(ord(text[0]) - int(ord('a'))) + 1
    move_types = [(1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1), (-2, -1), (-1, -2)]
    count = 0

    for i in range(len(move_types)):
        nx = row + move_types[i][0]
        ny = column + move_types[i][1]

        if nx < 1 or ny < 1 or nx > 8 or ny > 8:
            continue

        count += 1

    return count


# 출처 : 이것이 코딩테스트다(p115)