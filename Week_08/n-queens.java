import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        int size = (1 << n) - 1;
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<String>(), size, 0, 0, 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, ArrayList<String> strings, int size, int row, int pie, int na, int n) {
        if (row == size) {
            res.add(new ArrayList<>(strings));
            return;
        }
        
        int bits = ~(row | pie | na) & size;
        while (bits != 0) {
            int pos = bits & (-bits);
            bits -= pos;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (1 << i  == pos) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            strings.add(sb.toString());
            dfs(res, strings, size, row | pos, (pie | pos) << 1, (na | pos) >> 1, n);
            strings.remove(strings.size() - 1);
        }
    }
}
