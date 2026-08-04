class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        fillboard(board,cols,0);
        return ans;
    }

    void fillboard(boolean[][] board, boolean[] col, int row) {
        if(row == col.length) {
            fill(board);
            return;
        }

        for(int i = 0;i < col.length ; i++) {
            if(!col[i]) {
                if(checkboard(board,row,i)) {
                    col[i] = true;
                    board[row][i] = true;
                    fillboard(board,col,row+1);
                    col[i] = false;
                    board[row][i] = false;
                }
            }
        }
    }

    boolean checkboard(boolean[][] board,int row,int col) {
        // left top diagonal
        int i = row-1;
        int j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) return false;
            i--;
            j--;
        }
        // right top diagonal

         i = row-1;
         j = col+1;
        while(i >= 0 && j < board.length) {
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }

    void fill(boolean[][] board) {
        List<String> ls = new ArrayList<>();
        int n = board.length;

        for(int i = 0;i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < n ; j++) {
                if(board[i][j]) sb.append('Q');
                else sb.append('.');
            }
            ls.add(sb+"");
        }
        ans.add(ls);
    }

}