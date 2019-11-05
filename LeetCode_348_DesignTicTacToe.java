class TicTacToe {
    int board[][];
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkWin(row, col, player)) {
            return player;
        } else return 0;
    }
    
    private boolean checkWin(int row, int col, int player) {
        int i = 0;
        for (i = 0; i < board[row].length; i++) {
            if (board[row][i] != player ) {
                break;
            }
        }
        
        if (i == board.length) {
            return true;
        }
        
        for (i = 0; i < board.length; i++) {
            if (board[i][col] != player ) {
                break;
            }
        }
        
        if (i == board.length) {
            return true;
        }
        
        for (i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                break;
            }
        }
        
        if (i == board.length) {
            return true;
        }
        
        int curr = board.length - 1;
        for (i = 0; i < board.length && curr >= 0; i++) {
            if (board[i][curr] != player) {
                break;
            }
            curr--;
        }
        
        if (i == board.length) {
            return true;
        }
        
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */