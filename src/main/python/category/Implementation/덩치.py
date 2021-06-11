from sys import stdin

number = stdin.readline()
students = []
for i in range(int (number)) :
    weight, height = map(int, input().split())
    students.append((weight, height))

for j in students :
    rank = 1
    for k in students :
        if j[0]< k[0] and j[1] < k[1] :
            rank += 1;

    print(rank, end=" ")