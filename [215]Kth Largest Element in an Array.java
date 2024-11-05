// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         //数组排序后放入堆栈, 按照K次取出, 时间复杂度N*logN
//         Stack<Integer> stack = new Stack<>();
//         Arrays.sort(nums);
//         //栈特性练习,
//         // int res =0;
//         // for(int i=0;i < nums.length;i++){
//         //     stack.push(nums[i]);
//         // }
//         // for(int i=0;i<k;i++){
//         //     res = stack.pop();
//         // }
//         // return res;
//         return nums[nums.length-k];
//     }
// }

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //PriorityQueue默认是小顶堆, 最头部元素是最小的
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //添加k个元素到heap中
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        //遍历数组剩下的元素
        for (int i = k; i < nums.length; i++) {
            //每个元素和小顶堆的顶进行比较, peek获取顶部元素不删除, poll会删除
            if (nums[i] > minHeap.peek()) {
                //更新顶部元素
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        //大小为k的小顶堆, 顶部元素就是第k大了
        return minHeap.peek();
    }
}