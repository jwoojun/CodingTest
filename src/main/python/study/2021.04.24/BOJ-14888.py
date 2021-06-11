from itertools import permutations
N = 3
max_res, min_res = -10**9, 10**9
for o, n in zip(['+', '-', '*', '//'], list(map(int, input().split()))):
    if not n == 0:
        oper = oper + ([o]*n)
oper_combi = permutations(oper, N-1)