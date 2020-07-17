class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        update(board, click[0], click[1]);
        return board;
    }

    private void update(char[][] board, int i, int j) {
        //状态：1.B:表示已被挖出，不用继续递归
        //      2.E：表示未被挖出，需要继续向外扩散递归
        //      3.M：炸弹，不用递归
        //      4.数字：不用继续递归
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return ;
        }
        //击中地雷，修改之后直接返回
        if (board[i][j] == 'M') { 
            board[i][j] = 'X';
            return; 
        }
        //未击中地雷，首先计算当前格子变化
        else if (board[i][j] == 'E') {
            board[i][j] = caculate(board, i, j);
            //变化为B,则继续向周围扩散递归
            if (board[i][j] == 'B') {
                update(board, i - 1, j - 1);
                update(board, i - 1, j);
                update(board, i - 1, j + 1);
                update(board, i, j - 1);
                update(board, i, j + 1);
                update(board, i + 1, j - 1);
                update(board, i + 1, j);
                update(board, i + 1, j + 1);
            }
            //变化为数字，则就此打住
            else {
                return ;
            }
        }
    }

    //计算点开当前格子后的变化
    private char caculate(char[][] board, int i, int j) {
        //统计周围8格的地雷数
        int count = 0;
        if (exist(board, i - 1, j - 1) && board[i - 1][j - 1] == 'M') { count++; }
        if (exist(board, i - 1, j) && board[i - 1][j] == 'M') { count++; }
        if (exist(board, i - 1, j + 1) && board[i - 1][j + 1] == 'M') { count++; }
        if (exist(board, i, j - 1) && board[i][j - 1] == 'M') { count++; }
        if (exist(board, i, j + 1) && board[i][j + 1] == 'M') { count++; }
        if (exist(board, i + 1, j - 1) && board[i + 1][j - 1] == 'M') { count++; }
        if (exist(board, i + 1, j) && board[i + 1][j] == 'M') { count++; }
        if (exist(board, i + 1, j + 1) && board[i + 1][j + 1] == 'M') { count++; }
        if (count == 0) { return 'B'; }
        return (char)('0' + count);
    }
    //判断该棋子是否存在
    private boolean exist(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        return true;
    }
}
