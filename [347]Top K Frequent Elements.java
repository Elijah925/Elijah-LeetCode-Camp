class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //用负数代表次数, 以最小堆来实现最大堆效果
        //使用Collections.reverseOrder()实现最大堆也一样
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组,计次放入到map中, key为数组中的值, value为出现次数
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)-1);
        }

        //创建存放map的优先堆, 需要指定优先(大小)条件, 只用MapEntry后续方便
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                //此lambda代表在优先堆中以出现次数a小于b排序(最小堆,a在上,b在下)
                (a,b) -> a.getValue() - b.getValue()
        );

        //使用Map.Entry可以用entrySet方法一次性获得map中的所有key的集合
        //否则需要一个个获取key然后再根据key获取value
        //迭代遍历map中所有的key, 保存到优先堆中
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.offer(entry);
        }

        //长度为k的结果数组
        int res[] = new int[k];
        //遍历优先对的前k个map元素, 每个map元素用getKey方法获取key值(原数组中的值) 放入到结果数组中
        for(int i=0;i<k;i++){
            //这里顺序无所谓
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}