letter = input()


def check_palindrome(letter):
    for i in range(len(letter) // 2):
        if letter[i] != letter[-1 - i]:
            return False
    return True


if len(set(letter)) == 1:
    print(-1)
    exit()

if check_palindrome(letter) :
    print(len(letter)-1)
else :
    print(len(letter))