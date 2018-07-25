class Solution:

    def __init__(self):
        self.counter = 0

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.n = n
        self.queue = [-1] * n
        self.boards = []
        self.find(0)
        return self.boards

    def find(self, row):
        if row == self.n:
            board = []
            for (row, col) in enumerate(self.queue):
                line = ['.'] * self.n
                line[col] = 'Q'
                line = ''.join(line)
                board.append(line)
                if (row + 1) % self.n == 0:
                    self.boards.append(board)
        else:
            for col in range(self.n):
                if self.check(self.queue, row, col):
                    self.queue[row] = col
                    self.find(row+1)

    def check(self, queue, row, col):
        self.counter += 1
        for i in range(row):
            # 位置相同             左斜对角或者右斜对角
            if queue[i] == col or queue[i] - col == row - i or col - queue[i] == row - i:
                return False
        return True



if __name__ == '__main__':
    import sys
    n = int(sys.argv[1])
    s = Solution()
    boards = s.solveNQueens(n)
    # print(len(boards))
    for board in boards:
        for row in board:
            print(row)
        print()
    print(s.counter, len(boards))