import heapq

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.lo = []
        self.hi = []

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heapq.heappush(self.lo, num * -1)
        heapq.heappush(self.hi, heapq.heappop(self.lo) * -1)

        if len(self.lo) < len(self.hi):
            heapq.heappush(self.lo, heapq.heappop(self.hi) * -1)


    def findMedian(self):
        """
        :rtype: float
        """
        if len(self.lo) > len(self.hi):
            return self.lo[0] * -1
        return (self.lo[0] * -1 + self.hi[0]) / 2.0

if __name__ == '__main__':
    mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    print(mf.findMedian())
    print(mf.lo, mf.hi)
    mf.addNum(3)
    print(mf.findMedian())
    print(mf.lo, mf.hi)
