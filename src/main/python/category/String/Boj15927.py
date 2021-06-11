word = input().rstrip()

flag = False
l = len(word)

for i in range(l) :
    if word[:i] != word[l-i-1] :
        print(l)
        exit()
    elif word[i] != word[i+1] :
        flag = True

if flag :
    print(l-1)
    exit()
print(-1)

# flag = False
# l = len(word)
#
#
# for i in range(0, l // 2):
#     if word[i] != word[l - i - 1]:
#         print(l)
#         exit()
#     elif word[i] != word[i + 1]:
#         flag = True
#
# if flag :
#     print(l-1)
#     exit()
# print(-1)
# a="12345"
# print(a[len(a)-2:len(a)-1])
