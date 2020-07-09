class Solution {
    public List<String> generateParenthesis(int n) {
        //自顶向下，考虑当前函数的逻辑
        //生成所有括号，输出
        List<String> result = new ArrayList<>();
        //逻辑函数
        generate(0, 0, n, new StringBuilder(), result);
        return result;
    }

    /*
        left : 当前字符串中左括号个数
        right : 当前字符串右括号个数
        n : 需要生成的括号对数
        s : 当前字符串
        result : 存储结果链表
    */
    private void generate(int left, int right, int n, StringBuilder sb,List<String> result) {
        //递归终止条件 ： 左括号和右括号个数均达到上限
        if (left == n && right == n) {
            //将该字符串加入结果中
            result.add(sb.toString());
        }
        // //当前处理层，在当前字符串中添加左括号或右括号
        // String s1 = s + "(";
        // String s2 = s + ")";

        // //进入到下一层
        // generate(left + 1, right, n, s1, result);
        // generate(left, right + 1, n, s1, result);

        //对于进入下一层的提前剪枝：
        //只有左括号还没达到n个的时候才能添加左括号
        //同理只有左括号个数大于右括号的时候才能添加右括号
        //将两步统一处理
        // if (left < n) {
        //     generate(left + 1, right, n, s + "(", result);
        // }
        // if (left > right) {
        //     generate(left, right + 1, n, s + ")", result);
        // }

        //进一步优化，不使用String使用StringBuilder
        if (left < n) {
            generate(left + 1, right, n, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            generate(left, right + 1, n, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        //清理当前层
    }
}
