word = input()
letter = input()

count = 0
answer = 0
while count < len(word):
    if word[count:count + len(letter)] == letter:
        count += len(letter)
        answer += 1
    else:
        count += 1
print(answer)
