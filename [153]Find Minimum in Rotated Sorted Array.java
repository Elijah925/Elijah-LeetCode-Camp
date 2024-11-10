class Solution {
    public int findMin(int[] nums) {
        //略微修改二分法, 题目中 hint 3 对比 每一个mid值和第一个数决定下一次移动方向
        int target = nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            //正常二分法是递增数组, 当中点值大于目标值的话应该是end = mid - 1, 往左移动
            //这里需要找到旋转的拐点, 中点值大于目标值, 即目前为止都是递增情况, 需要继续往右移动找拐点
            //这题找拐点是因为排序数组旋转后,拐点就是最小值,不需要进行其他判断,可直接返回
            if (nums[mid] >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            //不管正常二分查找法或此题修改后,while循环结束时, 最终结果都是目标数, 不需要修改mid
            //每次需要调用min方法取小值, 防止极端情况下数组旋转次数为N次, case 3
            target = Math.min(target,nums[mid]);
        }
        return  target;
    }
}