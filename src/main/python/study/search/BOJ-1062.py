# import sys
#
# input = sys.stdin.readline
#
# N, K = map(int, input().split())
# alpha_lst = []
# for_alpha_lst = []
#
#
# def remove_fun(alphas):
#     common = ['a', 't', 'n', 'i', 'c']
#     for i in common:
#         if i in alphas:
#             alphas.remove(i)
#
#     return alphas
#
#
# def add_alpha(string, lst):
#     for i in string:
#         if i not in lst:
#             lst.append(i)
#
#
# for i in range(N):
#     alpha = input().rstrip()
#     lst = remove_fun(list(set(alpha)))
#     for_alpha_lst.append((len(lst), lst))
#
# for_alpha_lst.sort()
# print(for_alpha_lst)
