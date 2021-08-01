import sys
N, H = map(int, sys.stdin.readline().split())
top = [0] * (H + 1)  # 종유석
bottom = [0] * (H + 1)  # 석순

for i in range(N):
    num = int(input())
    if i % 2:
        top[num] += 1
    else:
        bottom[H - num + 1] += 1

# 종유석은 높이 H부터 하나씩 줄여가면서 갯수를 세준다.
# ex ) 높이가 3일때 길이가 3 이상인 종유석은 반드시 지나가게 되므로 높이를 줄여가면서 누적합(prefix sum)으로 해결할 수 있다.
for i in range(H - 1, 0, -1):
    top[i] += top[i + 1]


# 석순은 높이 1부터 하나씩 늘려가면서 갯수를 세준다.
# ex ) 높이가 3일때 길이가 3 이상인 석순은 반드시 지나가게 되므로 높이를 늘려가면서 누적합(prefix sum)으로 해결할 수 있다.
for i in range(1, H + 1):
    bottom[i] += bottom[i - 1]
total = [0] * (H + 1)


# 누적합을 쓰는 이유는 인덱스에 빠르게 가려고

# 각각의 높이에서 석순과 종유석의 누적합 더해주기
for i in range(1, H + 1):
    total[i] = top[i] + bottom[i]
print(total)
# 0번 높이는 삭제
total = total[1:]
ans = min(total)
print(ans, total.count(ans))  # 결과 출력

# 장애물을 피하는게 아니라 파괴; ?;;
