# 10570. 제곱 팰린드롬 수

def is_palindrome(n):
    if str(n) == str(n)[::-1]:
        return True

    return False


def is_int(n):
    a = n ** (1 / 2)
    if a == int(a) and str(int(a)) == str(int(a))[::-1]:
        return True

    return False


N = int(input())
for j in range(N):
    a, b = map(int, input().split())
    count = 0
    for i in range(a, b + 1):
        if is_int(i) and is_palindrome(i):
            count += 1
    print(f'{"#" + str((j + 1))} {count}')

