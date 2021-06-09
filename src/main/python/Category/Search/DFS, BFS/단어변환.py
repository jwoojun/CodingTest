from collections import deque
changed = []
def solution(begin, target, words):
    if target not in words:
        return 0

    answer = 0
    count = 0
    while 1:
        word = words[count % len(words)]
        if (equalToAnswer(begin, target)):
            return answer + 1

        else:
            if (equalToNextWord(begin, word) and (word not in changed)):
                changed.append(begin)
                begin = word
                answer += 1
            count += 1


def equalToNextWord(word, target):
    count = 0
    for i in range(len(target)):
        if word[i] != target[i]:
            count += 1
            if count >= 2:
                return False
    return True


def equalToAnswer(word, target):
    count = 0
    for i in range(len(target)):
        if word[i] != target[i]:
            count += 1
            if count >= 2:
                return False
    if count == 0:
        return False

    return True if count!=0 else False

# begin = "hit"
# target = "cog"
# words = ["hot", "dot", "dog", "lot", "log"]
# words = ["hot", "dot", "dog", "lot", "log", "cog"]
# words = ["cog", "log", "lot", "dog", "dot", "hot"]
# print(solution(begin, target, words))



