# https://www.acmicpc.net/problem/2798

a, b = list(map(int, input().split()))
cards = list(map(int, input().split()))
answer = []

# 서로 다른 두 원소를 뽑아서 합 구하기
for i in range(len(cards)-2) :
    for j in range(i+1, len(cards)-1) :
        for k in range(j+1,len(cards)) :
            if (cards[i]+cards[j]+cards[k]) <= b :
                answer.append((cards[i]+cards[j]+cards[k]))

print(max(answer))