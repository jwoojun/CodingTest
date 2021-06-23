N = int(input())
word = []

for _ in range(N) :
    word.append(list(input()))

dic = {}
for i in range(len(word)) :
    for j in range(len(word[i])) :
        if word[i][j] not in dic :
            dic[word[i][j]] = 10 ** (len(word[i])-j-1)
        else:
            dic[word[i][j]] += 10** (len(word[i])-j-1)

dic = sorted(dic.items(), key=lambda x:x[1], reverse=True)
result, num = 0, 9
for i in range(len(dic)) :
    result += num*dic[i][1]
    num -= 1
print(result)

