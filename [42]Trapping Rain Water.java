//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 32618 👎 549


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        // 初始化左右边界,边界内才可以积水
        int leftH = height[left];
        int rightH = height[right];
        int rain = 0;

        while (left < right) {
            // 对比左右边界移动短的一边
            if (leftH < rightH) {
                left++;
                // 移动后, 取当前高度和指针指向高度的最大值(木桶边界)
                leftH = Math.max(leftH, height[left]);
                // 边界高度减去当前高度就是当前索引处可积水容量
                rain += leftH - height[left];
            }
            //移动右指针,原理同上
            else {
                right--;
                rightH = Math.max(height[right], rightH);
                rain += rightH - height[right];
            }
        }
        return rain;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
