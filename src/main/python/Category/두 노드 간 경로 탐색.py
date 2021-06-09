V = 5
AL = [[] for _ in range(V + 1)]

edges = [(1, 2), (2, 3), (1, 4), (2, 4), (1, 5), (3, 5)]

AM = [[0] * (V + 1) for _ in range(V + 1)]

for s, e in edges:
    AM[s][e] = 1

for i in AM :
    print(i, end='\n')
# n = 5
# AM = [[0]*(n+1) for _ in range(n)]
# edges = [(1,2), (2,3), (1,4), (2,4), (1,5), (3,5)]
#
# for s,e in edges :
#     AM[s][e] = 1
# for i in AM :
#     print(i, end='\n')
