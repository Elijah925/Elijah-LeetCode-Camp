class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 调用深度优先搜索方法
        dfs(0, 0, "", n, res);
        return res;
    }

    private void dfs(int openP, int closeP, String s, int n, List<String> res) {
        // 如果左右括号数量达到目标数，保存当前组合
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        // 如果左括号数量小于 n，继续添加左括号
        if (openP < n) {
            dfs(openP + 1, closeP, s + "(", n, res);
        }

        // 如果右括号数量小于当前左括号数量，继续添加右括号
        if (closeP < openP) {
            dfs(openP, closeP + 1, s + ")", n, res);
        }
    }
}

/*
    从左右括号都为0开始, 遍历完((())) 的情况后 继续回溯
    对于回溯路径上不同数量左括号的情况, 进行添加右括号判断
    "" (openP=0, closeP=0)
├── "(" (openP=1, closeP=0)
│    ├── "((" (openP=2, closeP=0)
│    │    ├── "(((" (openP=3, closeP=0)
│    │    │    ├── "((()" (openP=3, closeP=1)
│    │    │    │    ├── "((())" (openP=3, closeP=2)
│    │    │    │    │    ├── "((()))" (openP=3, closeP=3) [VALID]

│    └── "(()" (openP=2, closeP=1)
│         ├── "(()(" (openP=3, closeP=1)
│         │    ├── "(()()" (openP=3, closeP=2)
│         │    │    ├── "(()())" (openP=3, closeP=3) [VALID]

│         └── "(())" (openP=2, closeP=2)
│              ├── "(())(" (openP=3, closeP=2)
│              │    ├── "(())()" (openP=3, closeP=3) [VALID]
*/