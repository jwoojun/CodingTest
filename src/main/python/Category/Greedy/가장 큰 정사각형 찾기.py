import itertools
def solution(board) :
    width, height =len(board[0]), len(board)
    for i in range(1, height) :
        for j in range(1, width) :
            if board[i][j] == 1 :
                board[i][j] = min(board[i-1][j], board[i][j-1], board[i-1][j-1])+1
    return max(itertools.chain(*board))**2