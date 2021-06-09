import math
import sys

input = sys.stdin.readline


n = int(input())
prime_numbers = [True] * (n+1)
answer = 0
# 에르난데스의 체
for i in range(2, int(math.sqrt(n)+1)) :
    j =2
    while i*j<=n :
        prime_numbers[i*j] = False
        j+=1

# 소수 판별 및 추가
# prime_numbers = [2,3, 5, 7, 11, 13 . . . ]
numbers= []
for i in range(2, n+1) :
    if prime_numbers[i] :
        numbers.append(i)


# 투포인터(라고 하기엔..?)
for i in range(len(numbers)) :
    interval_num = 0
    interval_num += numbers[i]
    if interval_num == n :
        answer += 1
    for j in range(i+1, len(numbers)) :

        interval_num += numbers[j]

        if interval_num <= n :
            if interval_num == n :
                answer +=1

            # 가장 작은 값으로 나오게 할 수 있다. 최상위 부모 노드를 출력할 수 있다.
            # 원하는 값 보다 작을 경우 다음항을 더해 줌
            # ex) 30을 찾는 경우
            #     소수 = [2, 3, 5, 7, 11, 13 . . . ]
            #   => 2 + 3 + 5 + 7 + 11 = 28
            #      28은 30보다 작기 때문에 +13을 더해준다.
        else :
            break
print(answer)



prime_number = numbers

count = 0
interval_sum = 0
end = 0

for start in range(len(prime_number)):
    while interval_sum < n and end < len(prime_number):
        interval_sum += prime_number[end]
        end += 1

    if interval_sum == n:
        count += 1
    interval_sum -= prime_number[start]

print(count)