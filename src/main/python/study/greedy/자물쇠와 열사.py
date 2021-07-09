def rotate(a) :
    n, m = len(a), len(a[0])
    result = [[0]*n for _ in range(m)]
    for i in range(n) :
        for j in range(m) : result[j][n-i-1] = a[i][j]
    return result

# 푸는 중
