# 왕실의 나이트
word = input()

# 문자 입력 및 변환
x, y = word[0], int(word[1])
x = ord(x) - ord(x) + 1

# 이동 방향
move_types = [(-2, 1), (-2, -1), (-1, 2), (-1, -2), (2, -1), (2, 1), (1, 2), (1, -2)]

answer = 0

for i in range(len(move_types)):
    nx = x + move_types[i][0]
    ny = y + move_types[i][1]
    if 1 <= nx <= 8 and 1 <= ny <= 8:
        answer += 1

print(answer)
