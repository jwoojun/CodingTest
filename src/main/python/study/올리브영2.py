import sys
from collections import deque

input = sys.stdin.readline

position = []


def change(x, y, l, r, b, t):
    new_x = (l + x % (r - l))
    new_y = (b + y % (t - b))
    position.append((new_x, new_y))


def findPosition(x, y, r):
    left, right, bottom, top = 0, 0, 0, 0
    if x[0] < x[1]:
        left = x[0] - r[0]
        right = x[1] + r[1]
    else:
        left = x[1] - r[1]
        right = x[0] + r[0]

    if y[0] < y[1]:
        bottom = y[0] - r[0]
        top = y[1] + r[1]
    else:
        bottom = y[1] - r[1]
        top = y[0] + r[0]

    return left, right, bottom, top



v = [92, 83, 14, 45, 66, 37, 28, 9, 10, 81]
# x = [3,4]
# y = [3,5]
# r = [2,3]
x = [5]
y = [5]
r = [5]


def containPosition(x, y):
    return l <= x <= r and b <= y <= t

lst = []

start =[0,0]

print(x)
count = 0
if len(x) == 1 :
    for i in range(0, len(v) - 1, 2):
        x_position = [0, x[0]]
        y_position = [0,y[0]]
        r= [0,5]
        left, right, bottom, top = findPosition(x_position, y_position, r)
        change(v[i], v[i+1], left, right, bottom, top)
        for j in position :
            x, y = j
            if containPosition(x, y) :
                count+=1
print(count)

