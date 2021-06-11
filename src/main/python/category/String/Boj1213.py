import collections
from collections import defaultdict

word = input()
word = list(word)
word.sort()
impossible = "I'm Sorry Hansoo"
words = collections.Counter(word)


def check(lst):
    if (len(lst)) % 2 == 0:
        for i in lst.values():
            if i % 2 != 0:
                return False
        return True

    else:
        count = 0
        for i in words.values():
            if i % 2 != 0:
                count += 1

            if count >= 2:
                return False
        return True


dic = defaultdict(list)
for i in word:
    dic[i].append(i)

start = list()
mid = list()
if len(dic[i]) % 2 == 0:
    for i in dic:
        for j in range(len(dic[i]) // 2):
            start.append(dic[i].pop(0))

    answer = "".join(start) + "".join(sorted(start, reverse=True))
    print(answer)
    exit()


else:
    for i in dic[i]:
        if len(dic[i]) % 2 != 0:
            for j in dic[i]:
                mid.append(dic[i].pop(0))
    for i in dic:
        if len(dic[i]) != 0:
            for j in range(len(dic[i]) // 2):
                start.append(dic[i].pop(0))
    answer = "".join(start) + "".join(mid) + "".join(sorted(start, reverse=True))
    print(answer)
    exit()
print(impossible)
