class N_Queens_II {
    private int size;
    public int totalNQueens(int n) {
         size = n;
        return bt(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int bt(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols){
        if(row==size)
            return 1;
        int sol = 0;
        for(int col =0; col<size; col++){
            int currDiagonal = row-col;
            int currAntiDiagonal = row+col;
            if(diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal) || cols.contains(col)) continue;
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            sol += bt(row+1, diagonals, antiDiagonals, cols);
            
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }

        return sol;
    }
}
