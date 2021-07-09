word = input()
letter = input()

count = 0
ans = 0
while count < len(word):
    if word[count:count + len(letter)] == letter:
        count += len(letter)
        ans += 1
    else:
        count += 1
print(ans)
