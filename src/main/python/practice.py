import sys
input = sys.stdin.readline


N = int(input())
max_result = -1e9
min_result = 1e9
numbers= list(map(int,input().split()))
plus, minus, multi, div = map(int,input().split())
op_count = plus+minus+ multi+div
result = 0
def dfs(result, count, plus, minus, multi, div) :
    global max_result, min_result
    if count-1 == op_count :
        max_result = max(result, max_result)
        min_result = min(result, min_result)
        return
    if plus > 0 :
        dfs(result+numbers[count], count+1, plus-1, minus, multi, div)
    if minus > 0 :
        dfs(result-numbers[count], count+1, plus, minus-1, multi, div)
    if multi > 0 :
        dfs(result*numbers[count], count+1, plus, minus, multi-1, div)
    if div > 0 :
        dfs(int(result/numbers[count]), count+1, plus, minus, multi, div-1)

dfs(numbers[0], 1, plus, minus, multi, div)
print(max_result)
print(min_result)




# N =  int(input())
# numbers = list(map(int,input().split()))
# operation_count = list(map(int,input().split()))


# a = -3
# b = 2
#
# print(a//b)
# print('------')
#
# a = -3
# b = 2
# print(-abs(a)//2)
#
#
