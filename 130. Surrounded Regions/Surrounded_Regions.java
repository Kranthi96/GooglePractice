class Surrounded_Regions {
    protected int ROWS = 0;
    protected int COLS = 0;
    public void solve(char[][] board) {
        if(board == null || board.length ==0)
            return;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<>();

        for(int r=0; r<this.ROWS; r++){
            borders.add(new Pair<>(r, 0));
            borders.add(new Pair<>(r, this.COLS-1));
        }

        for(int c=0; c<this.COLS; c++){
            borders.add(new Pair<>(0, c));
            borders.add(new Pair<>(this.ROWS-1, c));
        }
        for(Pair<Integer, Integer> p : borders){
            dfs(board, p.getKey(), p.getValue());
        }

        for(int r=0; r< this.ROWS; r++){
            for(int c=0; c<this.COLS; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'E') board[r][c] = 'O';
            }
        }

        
    }

    public void dfs(char[][] board, int x, int y){
        if(board[x][y] != 'O') return;
        board[x][y] = 'E';
        if(y+1 < this.COLS) dfs(board, x, y+1);
        if(x+1 < this.ROWS) dfs(board, x+1, y);
        if(y-1 >=0) dfs(board, x, y-1);
        if(x-1 >=0) dfs(board, x-1, y);
    }
}
