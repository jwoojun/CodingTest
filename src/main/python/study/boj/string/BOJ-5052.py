import sys
input = sys.stdin.readline

def check_consistency(phone_numbers) :
    phone_numbers.sort()
    for i in range(len(phone_numbers)-1) :
        if phone_numbers[i+1].startswith(phone_numbers[i]) :
            return False
    return True

answer = []
for i in range(int(input())) :
    numbers = []
    for j in range(int(input())) :
        numbers.append(input().rstrip())

    if check_consistency(numbers) :
        answer.append("YES")
    else :
        answer.append("NO")

for k in answer :
    print(k)
