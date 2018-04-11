### [Non-decreasing Array](https://leetcode.com/problems/non-decreasing-array/description/)

也许考察的是贪心算法,反正我是没有好的方法,总是越写越多.对这个简单的问题,一开始觉得很简单,
但总是忽略了某种情形.这个问题考察的究竟是啥呢?或许是贪心算法吧.对于这种不理解本质上考察的是什么的题.
即便当时会了,也会很快忘记,因为不能理解题的本质,做不到举一反三.只是机械地单纯地在刷题而已,没有什么意义.

Discuss中第一个解法

```Java
class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
        }
        return cnt <= 1;
    }
}
```

其中,所谓的贪心算法,其实就是对待当前序列中比较大的节点的处理方式,这里所谓的贪心,其实就是目光短浅的意思,
即当当前元素不符合序列的顺序时,我们处理当前元素的方法是参照这个元素两边元素的大小,而不是整个序列的大小来
最终决定当前元素的值.-这就是所谓的贪心的地方.

而且,这个贪心的策略是成立的.

这个贪心策略很简单,仔细想一下就知道了.

等价的解法:

```Java

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                // 下面两句话就是所谓的贪心策略并且虽然你质疑他,但是他是对的.
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
```

这样也许更容易理解一些,其实要修改某一位置的值是共识,分歧在于是把较大的修改为较小的还是把
较小的修改为较大的.注意:并没有一种唯一的标准,这里所谓的标准就是往前看一步,如果前面两个元素都比
后面那个元素大,则修改后面那个元素;如果只有中间一个元素大于右边的元素,而左边的元素小于右边的元素,
则修改中间的元素.

第一种情况:

```
... 2 3 1 ...
```

修改第三个元素

第二种情况:

```
... 1 3 2 ...
```

修改第二个元素

如果是一开始只有两个元素:

```
3 1 | 1 2 3
```

这里,默认把较大的元素修改为较小的元素,因为序列是升序的,将较大的修改为较小的总是符合规定的.