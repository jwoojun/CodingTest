import sys
input = sys.stdin.readline

N = int(input())

for i in range(N) :
    dp_table = [[1,0,0], [1,1,0], [1,1,1], [1,2,1]]
    number = int(input())
    max_index = len(dp_table)-1
    if number > max_index :
        for i in range(4, number) :
            lst = []
            lst.append(dp_table[i-1][0])
            lst.append(dp_table[i-2][0]+dp_table[i-2][1])
            lst.append(dp_table[i-3][0]+dp_table[i-3][1]+dp_table[i-3][2])
            dp_table.append(lst)
        print(sum(dp_table[number-1]))
    else :
        print(sum(dp_table[number-1]))
