class Solution {
    private int n;
    private int m;

    public int numEnclaves(int[][] grid) {
        int count = 0;
        // n的数值是矩阵有多少行, case 1为4行, m为有多少列, case 1 为5
        n = grid.length;
        m = grid[0].length;
        // 当n为0时,矩阵为空,
        if (n == 0)
            return 0;

        // 可用嵌套循环,遍历整个矩阵的4个边, 代码更短, 但是时间会更久
        // 上
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                DFSMarking(grid,0, i);
            }
        }
        // 下
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 1) {
                DFSMarking(grid,n - 1, i);
            }
        }
        // 左
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                DFSMarking(grid,i, 0);
            }
        }
        // 右
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                DFSMarking(grid,i, m - 1);
            }
        }

        //删除所有与边界相连的土地后,循环遍历所有land并计数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // 对于每个矩阵中的元素, 如果值为1(代表陆地),
                    // 调用DFS方法递归清空属于该岛屿的陆地(相邻的1)
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSMarking(int[][] grid, int i, int j) {
        // 判断i和j符合矩阵大小(不超边界), 和当前元素是否为0(海水)
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0)
            return;
        // 如果不为0, 就沉没陆地, 然后递归调用, 遍历上下左右所有相邻的陆地进行沉没
        grid[i][j] = 0;
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}