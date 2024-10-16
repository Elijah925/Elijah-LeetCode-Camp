//第53题
class Solution {
    public int maxSubArray(int[] nums) {
        //sum是一段subarray的和
        int sum =0;
        int result = nums[0];

        for(int i=0;i<nums.length;i++){
            //取最大值,从头开始计算,当数字小于零时放弃该区间(在这里是前三位和小于0被抛弃)
            //正结果已经存到result中
            if(sum<0){sum=0;}

            //计算从第一个正区间开始到第i位的和
            //例如第一个正数是1,加到-3被放弃,-3也放弃,然后到4
            //测试用例      [-2,1,-3,4,-1,2,1,-5,4]
            //sum测试用例中为 -2 1 -2 4  3 5 6  1
            sum+=nums[i];


            //System.out.println(sum);
            //取result和sum的最大值赋值到result
            result = Math.max(result,sum);
        }

        return result;
    }
}


//第56题
class Solution {
    public int[][] merge(int[][] intervals) {
        //对数组进行排序
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //需要动态添加删除所以创建链表
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){

            int[] compareArray = merged.getLast();

            //compareArray[1] 最后一个区间数组的右边界, intervals[i][0] 下一个对比数组的左边界
            //if判断是否有重叠区间
            if(compareArray[1] >= intervals[i][0]){
                //取两个右边界的最大值
                //compareArray元素是浅拷贝,更改时merged列表里最后一个区间数组的右边界一起更改了
                compareArray[1] = Math.max(compareArray[1],intervals[i][1]);
            }
            else{
                merged.add(intervals[i]);
            }
        }

        // 二维数组的实例方法需要返回二维数组
        return merged.toArray(new int[merged.size()][]);
    }
}

//第189题
class Solution {
    public void rotate(int[] nums, int k) {

        // for(int j=0;j<k;j++){
        //     int[] result =  nums.clone();
        //     int c=result[nums.length-1];
        //     for(int i=nums.length-1;i>0;i--){
        //         nums[i] = result[i-1];
        //         if(i==1){nums[0] = c;}
        //     }
        //     System.out.println(c);
        // }

        //计算当K大于数组长度,需移动次数
        if(k > nums.length){
            k=k%nums.length;
        }

        int[] result=new int[nums.length];
        int j=0;

        //将原数组从头开始复制到result数组从第K位
        for(int i=k;i<nums.length;i++){
            result[i]=nums[j];
            j++;
        }

        //将原数组第K位,复制到resutl数组从头开始
        for(int i=0;i<k;i++){
            result[i]=nums[j];
            j++;
        }

        System.arraycopy( result, 0, nums, 0, nums.length );
    }
}