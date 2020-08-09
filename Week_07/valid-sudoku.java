import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //一次遍历
        Set<Character>[] rows = new HashSet[board.length];
        Set<Character>[] cols = new HashSet[board.length];
        Set<Character>[] boxs = new HashSet[board.length];
        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                int boxIndex = (i / 3) * 3 + j / 3;
                if (num >= '1' && num <= '9') {
                    if (rows[i].contains(num)) {
                        return false;
                    }
                    if (cols[j].contains(num)) {
                        return false;
                    }
                    if (boxs[boxIndex].contains(num)) {
                        return false;
                    }
                    rows[i].add(num);
                    cols[j].add(num);
                    boxs[boxIndex].add(num);
                }
            }
        }
        return true;
    }
}
