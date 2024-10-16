//第41题
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 排序数组
        Arrays.sort(nums);
        int minPos = Integer.MAX_VALUE;
        // 遍历寻找数组中的最小正整数
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0 && minPos > nums[i]) {
                minPos = nums[i];
            }
        }
        // 判断minPos是否为1 , 优化方案中初始化为1就不用再次判断
        if (minPos == 1) {
            // 如果最小正数为1, 开始minPos+1
            for (int i : nums) {
                //如果右重复的就+1
                if (i == minPos) {
                    minPos++;
                }
            }
        } else {
            return 1;
        }
        return minPos;

        //优化方案 整合到1个for循环中
        // int minPos = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0 && nums[i] == minPos) {
        //         minPos++;
        //     } else if (nums[i] > minPos) {
        //         return minPos;
        //     }
        // }
        // return minPos;
    }
}


//第238题
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //暴力破解 时间复杂度 O(n平方)
        // int[] result = new int[nums.length];
        // for(int i=0;i<nums.length;i++){
        //     int sum=1;
        //     for(int j=0;j<nums.length;j++){
        //         if(i!=j){
        //             sum *= nums[j];
        //         }
        //     }
        //     result[i] = sum;
        // }
        // return result;

        //初始化结果数组, 乘积运算所以将数组内数据初始化为1
        //

        int[] result = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            result[i] = 1;
        }
        int left=1;
        int right=1;

//        Left pass:
//        Before traversal: output = [1, 1, 1, 1]
//        After 1st element: output = [1, 1, 1, 1] (left product of first element is 1)
//        After 2nd element: output = [1, 1, 1, 1] (left product of second element is 1 * 1)
//        After 3rd element: output = [1, 1, 2, 1] (left product of third element is 1 * 2)
//        After 4th element: output = [1, 1, 2, 6] (left product of fourth element is 1 * 2 * 3)
        //计算第i位数所有左边的乘积
        for(int i=0;i<nums.length;i++){
            result[i] *= left;
            left *= nums[i];
        }

//        Right pass:
//        Before traversal: right = 1
//        After 4th element: output = [1, 1, 2, 6] (right product of fourth element is 1)
//        After 3rd element: output = [1, 1, 8, 6] (right product of third element is 1 * 4)
//        After 2nd element: output = [1, 12, 8, 6] (right product of second element is 1 * 4 * 3)
//        After 1st element: output = [24, 12, 8, 6] (right product of first element is 1 * 4 * 3 * 2)
//        So the final output is [24, 12, 8, 6].
        for(int j=nums.length-1;j>=0;j--){
            result[j] *= right;

            //每次循环直接将结果与i位数的左乘积相乘输出到result
            right *= nums[j];
        }

        return result;
    }
}

//第560题
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        //创建哈希表,第一个Integer是前缀和,第二个integer是出现次数
        HashMap<Integer,Integer> arr_sum = new HashMap();
        arr_sum.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(arr_sum.containsKey(sum-k))
            {
                count+= arr_sum.get(sum-k);
            }
            if(arr_sum.containsKey(sum))
            {
                arr_sum.put(sum,arr_sum.get(sum)+1);
            }
            else
            {
                arr_sum.put(sum,1);
            }
        }
        return count;
    }
}
