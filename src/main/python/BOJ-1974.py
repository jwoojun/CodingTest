import sys
from collections import deque
input = sys.stdin.readline

dp_table =[""]*52
dp_table[1] = "BPPPB"
dp_table[2] = "BBPPPBPBPPPBB"
# N, X = map(int,input().split())

def eat(x, y) :
    global dp_table
    for i in range(1, x+1) :
        dp_table[x+1] = "".join("B"+dp_table[x]+"P"+dp_table[x]+"B")
        print(dp_table[x+1])
    count = 0
    print(dp_table[:5])
    dp_table[x] = dp_table[x][:y]

    for i in dp_table[x] :
        if i == "P" :
            count+=1
    return count

print(eat(3, 7))


