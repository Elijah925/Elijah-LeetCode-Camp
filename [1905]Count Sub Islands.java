class Solution {
    private int n;
    private int m;
    int land = 0;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        // n的数值是矩阵有多少行, case 1为4行, m为有多少列, case 1 为5
        n = grid1.length;
        m = grid1[0].length;
        // 当n为0时,矩阵为空,
        if (n == 0)
            return 0;

        // 嵌套循环,遍历整个矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid2[i][j] == 1) {
                    // 对于矩阵2中的元素, 如果值为1(代表陆地), 先默认是矩阵1的子岛
                    land = 1;
                    // 调用DFS方法递归清空属于该岛屿的陆地(相邻的1)
                    // 和200题不同的是需要再沉没岛屿时判断是否和矩阵1重叠
                    DFSMarking(grid1, grid2, i, j);
                    // 岛屿计数增加
                    count += land;
                }
        }
        return count;
    }

    private void DFSMarking(int[][] grid1, int[][] grid2, int i, int j) {
        // 判断i和j符合矩阵大小(不超边界), 和当前元素是否为0(海水)
        if (i < 0 || j < 0 || i >= n || j >= m || grid2[i][j] == 0)
            return;
        //每次递归相邻的land时, 需要判断这块土地时候也存在矩阵1中,
        //如果不存在, 将全局变量land从进入方法时默认的1, 改为0, 这块土地不为矩阵1的子岛
        //但是递归继续运行, 需要将矩阵2中这块岛屿完全清空
        if (grid1[i][j] == 0)
            land = 0;

        // 沉没陆地, 递归调用, 遍历上下左右所有相邻的陆地进行沉没
        grid2[i][j] = 0;
        DFSMarking(grid1, grid2, i - 1, j);
        DFSMarking(grid1, grid2, i + 1, j);
        DFSMarking(grid1, grid2, i, j + 1);
        DFSMarking(grid1, grid2, i, j - 1);
    }
}