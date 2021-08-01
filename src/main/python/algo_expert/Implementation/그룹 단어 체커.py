# 백준 1316
from collections import Counter
from sys import stdin


number = stdin.readline()
count = 0
for i in range(int(number)) :
    alpha = stdin.readlidne()
    alphaCount = Counter(alpha)
    for j in range(len(alpha)-1) :
        alphaCount[alpha[j]] -= 1
        if alphaCount[alpha[j]] !=0  and alpha[j] != alpha[j+1] :
            break
        if j == len(alpha)-2 :
            count += 1

print(count)
