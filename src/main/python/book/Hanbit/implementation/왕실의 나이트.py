# 왕실의 나이트
word = input().rstrip()

move = [(-2, 1), (-2, -1), (2, 1), (2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]

x_position = int(word[1])
y_position = int(ord(word[0]) - ord('a') + 1)

count = 0
for i in range(len(move)):
    next_x = x_position + move[i][0]
    next_y = y_position + move[i][1]
    if 1 <= next_x <= 8 and 1 <= next_y <= 8:
        count += 1
print(count)