class Solution {
    int count = 0;
    private int n;
    private int m;

    public int maxAreaOfIsland(int[][] grid) {
        int res =0;
        // n的数值是矩阵有多少行, case 1为4行, m为有多少列, case 1 为5
        n = grid.length;
        m = grid[0].length;
        // 当n为0时,矩阵为空,
        if (n == 0)
            return 0;

        // 嵌套循环,遍历整个矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    // 对于每个矩阵中的元素, 如果值为1(代表陆地),
                    // 调用DFS方法递归清空属于该岛屿的陆地(相邻的1)
                    //重置count为0, 否则返回的是整个矩阵的land数量
                    count =0;
                    //每次找到新land时, 和之前的结果取最大值
                    res = Math.max(res,DFSMarking(grid, i, j));
                }
        }
        return res;
    }

    private int DFSMarking(int[][] grid, int i, int j) {
        // 判断i和j符合矩阵大小(不超边界), 和当前元素是否为0(海水), 没有土地时返回0
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0)
            return 0;
        // 如果不为0, 就沉没陆地, 然后递归调用, 遍历上下左右所有相邻的陆地进行沉没
        grid[i][j] = 0;

        //每次沉没一块land时, 土地计数增加, 
        count++;
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);

        //最后返回land数量
        return count;
    }
}