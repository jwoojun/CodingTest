import sys
input = sys.stdin.readline

N, K = map(int, input().split())
if K < 5 or K == 26:
    print(0 if K < 5 else N)
    exit()

words = [set(input().rstrip()) for _ in range(N)]
learn = [False] * 26

for basic_word in ('a','c','i','n', 't') :
    learn[ord(basic_word)-ord('a')] = True

ans= None
def dfs(alphabet_index, count) :
    global ans

    if count == K-5 :
        reable_word = 0
        for word in words :
            for alphabet in word :
                if not learn[ord(alphabet)-ord('a')] :
                    break
            else :
                reable_word += 1

        answer = max(answer, reable_word) if answer else reable_word
        return


    for alphabet in range(alphabet_index, 26) :
        if not learn[alphabet] :
            learn[alphabet] = True
            dfs(alphabet, count+1)
            learn[alphabet] = False
dfs(0,0)
print(ans)




# import sys
#
# input = sys.stdin.readline
#
# N, K = map(int, input().split())
# alpha_lst = []
# for_alpha_lst = []
# alpha_table = [0] * 27
# answer = 0
# if K < 5 :
#     print(0)
#     exit()
# K -= 5
#
#
# def of(word):
#     # 테이블에 알파벳을 매핑
#     return ord(word) - ord('a')
# # a b
# # 0 1
#
# def enroll():
#     basic_alpha = ['a', 'c', 'i', 't', 'n']
#     for number in range(len(basic_alpha)):
#         alpha_table[of(basic_alpha[number])] = 1
#
#
# enroll()
#
#
# def remove_basic_word(word):
#     # 문자에서 중복 제거  -> ex) [a,a,b] -> [a,b]
#     word = set(word)
#     basic_alpha = ['a', 'c', 'i', 't', 'n']
#
#     # 기본 문자열이 포함되어 있으면 제거
#     # [a,b] -> [b]
#     for i in basic_alpha:
#         if i in word:
#             word.remove(i)
#
#     return list(word)
#
# flag = False
# tmp = []
# for i in range(N):
#     word = list(input().rstrip())
#     new_word = remove_basic_word(word)
#
#
#
#     tmp.append(new_word)
#
#
#     for number in new_word:
#         if alpha_table[of(number)] == 0:
#             if K != 0 :
#                 alpha_table[of(number)] = 1
#                 K -= 1
#             else :
#                 flag = True
#                 break
#     if flag :
#         flag = False
#         continue
#
#     answer += 1
#
# print(answer)
# print(tmp)
# print(ord('a'))




# alpha & (1<<index) == 0