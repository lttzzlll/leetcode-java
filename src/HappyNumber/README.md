### [Happy Number](https://leetcode.com/problems/happy-number/description/)

为了防止无限循环,用一个集合来保存计算出来的元素.
一旦遇到了计算出来的元素,表示进入了无限循环, return false;
