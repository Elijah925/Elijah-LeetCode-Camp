class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 需要再二分查找法基础上增加一层判断, 判断目标值和左右边界值,和mid值来决定移动方向
        //注意, 此题和153不同的是153找到拐点就可以确定最小值,可直接return
        //此题理思路的时候, 同样要考虑拐点在哪,但是拐点不是重点,只需要考虑是否过了拐点,

        //不经过拐点,就是还在增序数列,
        //确定target是否左边界(left)到mid的区间中,不在就移动左边界往右走(因为有拐点)
        //小于拐点也可能在右边, 例子2 

        //经过了拐点
        //确定target和右边界大小,此时不能用left判断,因为有拐点可能出现一段{7,8,2,3},目标值可能为3-7之间
        //所以判断是否在mid到right中, 不在就移动右边界,

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;

                //当目前mid值 > left值, 目前还是增序数列,没有达到拐点, 所以子条件语句中需要判断左边界
            } else if (nums[mid] >= nums[left]) {
                //注意, 二分发判断边界移动时,一定包含=号,这一步不会对比target
                //只判断移动方向, 移动边界索引, 然后继续循环, 直到索引mid的值等于target

                //判断targer是否在增序数列中,
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    //例子1中, 不管target小于4 或大于7, 都是需要移动左边界往右
                    left = mid + 1;
                }

                //此时nums[mid] < nums[left], 也就是已经过了拐点,此时需要判断右边界
            } else {
                //判断target是否在mid值和右边界(最开始是数组末端)中
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    //否则target在左边界到索引mid的区间中
                    right = mid - 1;
                }
                //个例情况下{11,12,13,14,15,16,1,2,3,4,5,6,7,8,9,10} target为1, mid为2
                //此时1小于右边界10, 但是2大于目标值, 所以移动右边界,然后在循环判断
            }

        }

        return -1;
    }
}