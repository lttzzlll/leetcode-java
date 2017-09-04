### [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)
> 使用41题[First Missing Positive](https://leetcode.com/problems/first-missing-positive/discuss/)的方法可以解决.
> Discuss中给出的方法非常好.不同于前面用交换元素的方式来获得position: value之间的关系,这里采用正负值来表示某个值是否出现在列表中,相当于一种染色法.
> 凡是存在于列表中的元素value,都将其对应位置nums[value - 1]  设置为 - nums[value - 1]此处设置为-1,-2都可以,只是做一个标记.
> 再次遍历列表,凡是索引对应的元素nums[position]被没有被标记为负数的,均表明 position + 1没有出现在列表中,所以nums[(position + 1) - 1]没有被标记为负数.