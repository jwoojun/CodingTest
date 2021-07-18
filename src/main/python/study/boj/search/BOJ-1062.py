import sys
input = sys.stdin.readline

N, K = map(int, input().split())
if K < 5 or K == 26:
    print(0 if K < 5 else N)
    exit()

words = [set(input().rstrip()) for _ in range(N)]
learn = [False] * 26
print(words)
for basic_word in ('a','c','i','n', 't') :
    learn[ord(basic_word)-ord('a')] = True

answer= None
def dfs(index, count) :
    global answer

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


    for alphabet in range(index, 26) :
        if not learn[alphabet] :
            learn[alphabet] = True
            dfs(alphabet, count+1)
            learn[alphabet] = False
dfs(0,0)
print(answer)