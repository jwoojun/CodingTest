# 부품 찾기(풀이1)
import sys

input = sys.stdin.readline

N = int(input())
product_lst = list(map(int, input().split()))

M = int(input())
check_lst = list(map(int, input().split()))

product_lst.sort()
check_lst.sort()


def binary_search(x, lst):
    start = 0
    end = len(lst) - 1

    while start <= end:
        mid = (start + end) // 2

        if lst[mid] == x:
            return "yes"
        elif lst[mid] > x:
            end = mid - 1
        else:
            start = mid + 1
    return "no"


ans = []
for i in check_lst:
    ans.append(binary_search(i, product_lst))

for i in ans:
    print(i)



# 부품 찾기(풀이2)




# TestCase
# 5
# 8 3 7 9 2
# 3
# 5 7 9
