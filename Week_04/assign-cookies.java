class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //排序
        Arrays.sort(g);
        Arrays.sort(s);
        //贪心：孩子的胃口从小到大进行排序
        //对于当前孩子，给他能满足他的最小的饼干即为局部最优解
        int count = 0;
        int index = 0; //饼干size的下标
        for (int child : g) {
            while (index < s.length && s[index] < child) {
                index++;
            }
            if (index >= s.length) { break; }
            index++;
            count++;
        }

        return count;
    }
}
