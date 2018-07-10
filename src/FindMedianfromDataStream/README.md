### [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/)

这个Hard的题就用下面这种很水的解法就过了.

```Java
class MedianFinder {

    ArrayList<Integer> array;

    public MedianFinder() {
        array = new ArrayList<>();
    }

    public void addNum(int num) {
        array.add(num);
    }

    public double findMedian() {
        array.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int l = array.size() / 2, r = l - 1;
            return (array.get(l) + array.get(r)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```

这个版本的算法插入的时候很简单,但是查找的时候比较麻烦,时间复杂度也都出在这样.
所以,插入操作的时间复杂度为O(1),查找的时间复杂度为O(nlog(n))
这种解法的时间复杂度是O(nlog(n)), 取决于排序算法的时间复杂度.

采用另外一种基于排序的解法:插入排序 + 二分查找

可恶的Java数据结构

```Python
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
        cnt = len(self.arr)
        half = cnt // 2
        if cnt % 2 == 1:
            return self.arr[half]
        return (self.arr[half] + self.arr[half - 1]) / 2.0

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
```

这是改进版本的排序方法,始终维护一个有序数组,这样虽然插入的时候比较麻烦,但是查询的时候比较简单.
这里,查询的时间复杂度为O(1),插入的时间复杂度为O(n).因为插入一个元素的时候先用二分查找法查找,
时间复杂度为O(log(n)),找到合适的位置后,移动元素的时间复杂度为O(n), 所以总的时间复杂度为
O(log(n)) + O(n) = O(n).

