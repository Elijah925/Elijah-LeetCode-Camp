class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 创建结果列表 和 层列表
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();

        // 初始化为1 numRows限制条件为>=1 (构建第一层)
        layer.add(1);
        res.add(layer);

        // 外循环用来控制运行的次数, 也就是生成多少行
        for (int i = 2; i <= numRows; i++) {
            // 创建当前构造的层列表,
            List<Integer> currlayer = new ArrayList<Integer>();
            //三角形的左边都是从1开始
            currlayer.add(1);

            //构建三角形内层, 用上一层的大小来做限制条件(layer.size - 1)
            //前后都手动添加了1作为边, 所以这里 size 需要 -1
            for (int j = 0; j < layer.size() - 1; j++) {
                currlayer.add(layer.get(j) + layer.get(j + 1));
            }
            //添加三角形右边
            currlayer.add(1);
            //更新层的大小(不断叠加)
            layer = currlayer;
            //保存结果
            res.add(currlayer);
        }
        return res;
    }
}