import bisect

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        idx = bisect.bisect(self.arr, num)
        self.arr.insert(idx, num)

    def findMedian(self):
        """
        :rtype: float
        """
        print(self.arr)
        cnt = len(self.arr)
        half = cnt // 2
        if cnt % 2 == 1:
            return self.arr[half]
        return (self.arr[half] + self.arr[half - 1]) / 2.0

if __name__ == '__main__':
    mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    print(mf.findMedian())
    mf.addNum(3)
    print(mf.findMedian())