class Solution {
    int count;
    public int totalNQueens(int n) {
        count = 0;
        int size = (1 << n) - 1;
        dfs(size, 0, 0, 0);
        return count;
    }

    private void dfs(int size, int row, int pie, int na) {
        if (row == size) {
            count++;
            return;
        }

        int bits = ~(row | pie | na) & size;
        while (bits != 0) {
            int pos = (bits & (-bits)); // 可下的最右的位置，取出bits的最右的1
            bits -= pos;
            dfs(size, row | pos, (pie | pos) << 1, (na | pos) >> 1);
        }
    }
}
