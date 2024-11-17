import java.util.ArrayList;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表，表示课程之间的先修关系
        //创建列表数组, 数组中索引指向的元素是列表,可以看作graph的节点数量
        ArrayList[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 构建邻接表，将每门课程的先修关系存储到列表中
        //将课程的先决条件保存到列表数组中
        //prereq[1]代表需要先修课程, 所以是1添加0
        for (int[] prereq : prerequisites) {
            adjList[prereq[1]].add(prereq[0]);
        }

        // 用于标记课程是否在当前递归路径上（检测是否有环）
        boolean[] onPath = new boolean[numCourses];
        // 用于标记课程是否已经被检查过（避免重复计算）
        boolean[] checked = new boolean[numCourses];

        // 遍历每门课程，检查是否有环
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjList, onPath, checked, i)) {
                return false; // 如果发现环，直接返回 false
            }
        }
        return true; // 如果所有课程都无环，则可以完成所有课程
    }

    private boolean dfs(ArrayList[] adjList, boolean[] onPath, boolean[] checked, int course) {
        // 如果当前课程在递归路径上，说明检测到环
        //onPath检查环的原理是每次到新课程的时候才设置为true, 递归到最底的时候开始返回, 才设置成false
        //如果所以如果37行if为true,说明还没到递归最底就已经第二次遇到某课程, 所以存在环
        if (onPath[course]) {
            return false;
        }

        // 如果当前课程已经被检查过，说明该课程之前已经确定无环
        //初始化为false, 之后递归到最底的时候,不存在环, 设置为true
        //注意,course是课程号,其实也就是索引,所以当if成立时, 该课程已经检查过了直接返回即可
        if (checked[course]) {
            return true;
        }

        // 标记当前课程进入递归路径
        onPath[course] = true;

        // 递归当前课程的所有后续课程
        for (Object neighbor : adjList[course]) {
            if (!dfs(adjList, onPath, checked, (int) neighbor)) {
                return false; // 如果发现环，直接返回 false
            }
        }

        // 当前课程递归结束，移除递归路径标记
        onPath[course] = false;
        // 标记当前课程已经被检查过
        checked[course] = true;

        return true; // 当前课程无环，返回 true
    }
}

//https://www.youtube.com/watch?v=EgI5nU9etnU&ab_channel=NeetCode
