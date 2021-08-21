import sys
from collections import deque
input = sys.stdin.readline

subway = ["1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"]
subways = []
for i in range(len(subway)) :
    subways.append(subway[i].split(" "))

