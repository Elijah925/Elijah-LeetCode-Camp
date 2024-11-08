class Solution {
    //常用二分搜索法
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分搜索矩阵的第一列, 
        int top = 0;
        int bot = matrix.length - 1;
        while (top <= bot) {
            int mid = (top + bot) / 2;
            if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target) {
                break;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        //最后出循环的结果为top=bot (停留在可能包含target的那一行), case 1为例, 需要一直移动某一边
        //或者top<bot,(停留在可能包括target的最近两行), case 2为例, 两边都需要移动,
        //System.out.println("top= " +top+" bot= "+bot);

        ////确定需要二分搜索矩阵的行
        //无论上一个循环结果是什么, 两个数的平均数一定是可能包含target的行, 找不到就是矩阵不包含target
        int row = (top + bot) / 2;
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

//简化行数版二分搜索, 把二维矩阵拉平, 看成一个数组,然后在搜索
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        //right就是矩阵的最后一个元素, example 1为例
        //3*4-1 = 11, right为第11个元素60
        int right = rows * cols - 1;

        while (left <= right) {
            //二分法取中间值
            int mid = (left + right) / 2;
            //获取中间值所在的行数, 例如5/4 = 1.25, int取整为1 
            int row = mid / cols;
            //获取中间值所在的列数, 例如6/4 余1 
            int col = mid % cols;
            //所以二分法中间值的所在位子就是matrix[row][col], 第一次循环guess为第一行的第一列, 11
            int guess = matrix[row][col];

            if (guess == target) {
                return true;
            } else if (guess < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}


//自己手写时间复杂度O(m*logN), 矩阵的每一列完全遍历, 需要优化
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length - 1;
//         int n = matrix[0].length - 1;
//         int row = 0;
//         if (target < matrix[0][0] || matrix[m][n] < target) {
//             return false;
//         }
//         for (int i = 0; i < matrix.length; i++) {
//             if (matrix[i][0] == target) {
//                 return true;
//             } else if (matrix[i][0] > target) {
//                 row = i - 1;
//                 break;
//             } else {
//                 row = i;
//             }
//         }
//         return findNum(matrix[row], target);
//     }

//     private boolean findNum(int[] nums, int target) {
//         int start = 0;
//         int end = nums.length - 1;
//         while (start <= end) {
//             int mid = (start + end) / 2;
//             if (nums[mid] <= target) {
//                 start = mid + 1;
//             } else {
//                 end = mid - 1;
//             }
//             if (nums[mid] == target)
//                 return true;
//         }

//         return false;
//     }
// }