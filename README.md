
# leetcode36 验证数独有效性
### 分为三个部分：
* 行验证
* 列验证
* 3*3方格验证
<br>**如果能在一起就验证就可以提高效率**

### 行验证和列验证集成
* 行和列每次只动一个数，这样就可以验证其中某一个但是可以倒过来使用，这样行就是列，列也就是行。

### 行列集成方格
* 观察小方格中各个坐标的横纵坐标
* 横坐标
> 第一到第三个 000111222 <br>
> 第四到第六个 333444555 <br>
> 第七到第九个 666777888
<br>**规律** 3*(i/3)+j/3
* 纵坐标
> 第一个第四个第七个 012012012 <br>
> 第二个第五个第八个 345345345 <br>
> 第三个第六个第九个 678678678
<br>**规律** 3*(i%3)+j%3


# leetcode 37 完成数独
不太行

# leetcode 38 countAndSay
* 递归思想
* 数出相同的元素个数然后加在字符串后面

# leetcode 39 组合数
### DFS找出排列
* 分层查找（递归） 每个数有个标志位
> 比如在[1,2,3]中进行深度为2的排列<br>第一层可以是任意的数（==number.length=3==）然后标志位置为true<br>第二层可以是除了标志位为true以外的任意数<br>当深度符合则排列完成进行下一次排列

### 组合
* 与之排列的区别是没有标志位 因为不可以交换顺序
* 每次循环从上一层后面的元素开始取

### 解题
* 每次都减去当前的数成为新的target target必须大于等于0 存储这个数
* 如果target为0则结束一组组成 这组数列加入result
* 如果大于0则继续进行操作

***
* 设想如果排序后是倒序
    * 倒序可以先减去最大的数但是有个问题就是小数不知道用几个
    * 反过来从小到大可以先把小的用到极限同时递归


# leetcode 40 组合数去重
* 和39题做法一样但是需要去重
* 两种思路
    * 使用set不重复的性质去重
    * 在同一深度不可以使用相同的数去重<br>即如果第一个数是1后面的组合数就不能再把1作为第一个数


# leetcode 40 组合数去重
* 和39题做法一样但是需要去重
* 两种思路
    * 使用set不重复的性质去重
    * 在同一深度不可以使用相同的数去重<br>即如果第一个数是1后面的组合数就不能再把1作为第一个数


# leetcode 41 找出缺失的最小正整数
* 就是一个数组从1开始排列到最大数 缺哪个最小的就是哪个

### 桶排序
对应的位置放对应的东西
* 在每个位置上放对应的数
* 比如第一个位置应该是1 既 1= nums[0]
* 如果不是就交换到对应的位置上 比如4= nums[3]
* 重复检查这个位置 直到变为对应的数(`nums[nums[i]-1] != nums[i]`)或者不满足交换条件(`nums[i] > 0 && nums[i] <= nums.length`)
* 最后遍历重排序后的数组 如果有哪个数不符合就返回这个数
* 如果全都符合就是最大的数
