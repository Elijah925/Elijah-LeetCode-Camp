//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
// 
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Greedy 👍 29745 👎 1861


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //初始化最大面积,当前面积,左右指针
        int max = 0;
        int cur = 0;
        int left = 0;
        int right = height.length-1;

        while(left<=right){
            //取左右指针对应数字的最小值(水桶装水)
            int side = Math.min(height[left],height[right]);

            //求当前面积
            cur = side * (right - left);

            //对比最大值
            if(cur > max){
                max = cur;
            }

            //算法核心是当移动指针往内移动时,长度在减少
            //所以需要移动高度矮的一边,以寻找增加数值比长度减少更大的数字
            //移动左右指针对应数字较小的一边
            if(height[left] < height[right]){
                left++;
            }
            else {right--;}
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
