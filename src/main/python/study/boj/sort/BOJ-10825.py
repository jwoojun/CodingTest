import sys

input = sys.stdin.readline

N = int(input())
students = []
for i in range(N):
    students.append(list(map(str, input().split())))

students = sorted(students, key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
for i in range(len(students)) :
    print(students[i][0])
