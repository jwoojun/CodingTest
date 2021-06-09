# 풀이1
string = list(map(str, input().split()))
answer = ''.join(string)
if int(answer) == 12345678:
    print('ascending')
if int(answer) == 87654321:
    print('descending')
if int(answer) != 12345678 and int(answer) != 87654321 :
    print('mixed')



# 풀이2
a = list(map(int, input().split(' ')))
ascending = True
descending = True
for i in range(1, 8) :
    if a[i] > a[i-1] :
        descending = False
    elif a[i] < a[i-1] :
        ascending = False

if ascending :
    print('ascending')
elif descending :
    print('descending')
else :
    print('mixed')