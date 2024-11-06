/**
 * Using two heaps
 *
 * Time Complexity:
 * 1) addNum -> O(5 * log (N/2)) = O(log N)
 * 2) findMedian -> O(1)
 *
 * Space Complexity: O(N)
 *
 * N = Count of numbers in the data stream.
 */
class MedianFinder {
    PriorityQueue<Integer> smallNums; // Max Heap
    PriorityQueue<Integer> largeNums; // Min Heap
    //利用最小堆和最大堆特性, 面对增序数列时,两个堆的顶部为中位数,或者最大堆的顶部是中位数
    public MedianFinder() {
        //中位数左边的堆smallNums(中位数的左边,都是小于等于中位数的值)需要取最大的数
        smallNums = new PriorityQueue<>(Collections.reverseOrder());
        //中位数右边的堆, 取最小的数字,
        largeNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 添加数字时,先添加到左堆
        smallNums.offer(num);
        // 然后再将左堆的顶部添加到右堆
        largeNums.offer(smallNums.poll());
        //上面这一步主要是判断添加的数字大小
        //先到左堆,在从左堆顶部取一个元素, 确保添加元素后, 将左堆的最大值取出

        //判断左右堆大小, 单数情况下, 左堆比右堆大,左堆顶部为中位数
        if (largeNums.size() > smallNums.size()) {
            smallNums.offer(largeNums.poll());
        }
    }

    public double findMedian() {
        //判断两个堆的大小, 如果不一样大, 单数情况取左堆顶部
        if (smallNums.size() != largeNums.size()) {
            return smallNums.peek();
        }

        //if未生效, 偶数情况, 取平均值
        return (smallNums.peek() + largeNums.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
