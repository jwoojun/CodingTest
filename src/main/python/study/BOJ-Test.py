import sys
from collections import deque
input = sys.stdin.readline

s, t = map(int,input().split())
operation =["*", "+", "/"]




def isEqual(s, t) :
    if s == t :
        print(0)
        exit()

def isZero(t) :
    if t == 0 :
        print("-")
        exit()

def isFirst(t) :
    if t == 1 :
        print("/")
        exit()

def visitable(x) :
    return x not in visited and x != -1

def valid(x, operation) :
    global t
    if operation == "*" :
        if x*x > t :
            return -1
        else :
            return x*x
    else :
        if operation == "/" and x != 0:
            return 1
        if operation == "+" :
            if x*2 > t :
                return -1
            else :
                return x*2

isEqual(s, t)
isZero(t)
isFirst(t)

q = deque()
visited = []
q.append((s, ""))
visited.append(s)

while q :
    number, answer = q.popleft()
    if number == t :
        print(answer)
        exit()

    for i in range(3) :
        next_number = valid(number, operation[i])
        if visitable(next_number) :
            visited.append(next_number)
            q.append((next_number, answer+operation[i]))

print(-1)
