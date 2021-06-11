# solution1
def searchInSortedMatrix(matrix, target):
    # 초기 행 : 0 / 초기 열 : 행의 마지
    row, column = 0, len(matrix[0])-1

    while (row < len(matrix)) & (column >= 0) :
        # target보다 크면 왼쪽(열) 이동.
        if matrix[row][column] > target :
            column -= 1
        # target보다 작으면 아래(행) 이동.
        elif matrix[row][column] < target :
            row += 1

        # 원하는 수를 찾았으면 값을 return
        else :
            return [row, column]

    # 그 외는 [-1, 1] return
    return [-1, -1]



# solution2
def searchInSortedMatrix(matrix, target):
    # 2중 for문을 돌려서 원하는 값이 나오면 return
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == target:
                return [i, j]

    # 그 외는 [-1, -1] return
    return [-1, -1]


