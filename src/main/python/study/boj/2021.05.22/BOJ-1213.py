import sys

name = list(input().strip())
alpha_count = [0 for _ in range(26)]

temp = ""
ans = ""

for i in range(len(name)):
    alpha_count[ord(name[i]) - 65] += 1

odd = 0
for i in range(26):
    if alpha_count[i] % 2 == 1:
        odd += 1
        temp += alpha_count[i]

        if odd > 2:
            print("I'm Sorry Hansoo")
            exit()

    ans += chr(i + 65) * (alpha_count[i // 2])

ans = ans + temp + ans[::-1]
print(ans)

# if odd > 1:
#     print("I'm Sorry Hansoo")
# else:
#     print(answer + temp + "".join(map(str, reverse_answer)))
