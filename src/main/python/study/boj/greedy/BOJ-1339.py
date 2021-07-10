# 단어 수학
N = int(input())
words = []

for i in range(N):
    words.append(list(input().rstrip()))
numbers = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
alpha_digits = {}
for i in range(len(words)):
    for j in range(len(words[i])):

        if words[i][j] not in alpha_digits:
            # 딕셔너리에 없는 경우 자릿수를 저장
            alpha_digits[words[i][j]] = 10 ** (len(words[i]) - 1 - j)
            print(alpha_digits, "없는 경우")

        else:
            # 딕셔너리에 있는 경우 자리수 만큼 더한다
            alpha_digits[words[i][j]] += 10 ** (len(words[i]) - 1 - j)
            print(alpha_digits, "있는 경우")

# items() -> (key, value) 형태로 저장
alpha = sorted(alpha_digits.items(), key=lambda x: x[1], reverse=True)
result = 0

for i in range(len(alpha)):
    result += alpha[i][1] * numbers[i]
print(result)


alpha = "ABCDE"

#       자릿수    가중치
#  A   10000 ->   9
#  B    1000 ->   8
#  C     100 ->   7
#  D      10 ->   6
#  E       1 ->   5

max_result = (10000 * 9) + (1000 * 8) + (100 * 7) + (10 * 6) + (1 * 5)



# A B C D E F G
# 9 3 4 6 7 8 5
#   4 6 5 3 4 2
#     4 3 5 8 2
# 5억 ->

