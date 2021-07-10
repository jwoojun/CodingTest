def is_prime(n):
    if n == 1:
        return False

    if n == 2:
        return True

    # √(루트) 씌워서 +1
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False

    else:
        return True


def solution(n):
    count = 0
    for k in range(1, n + 1):
        if is_prime(k) == True:
            count += 1

    return count