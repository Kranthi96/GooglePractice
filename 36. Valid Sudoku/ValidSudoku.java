class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
//         int[][] row = new int[9][10];
//         int[][] col = new int[9][10];
//         int[][] box = new int[9][10];
//         for(int i=0;i<9;i++){
//             for(int j=0; j<9;j++){
//                 if(board[i][j] == '.') continue;
//                 int k = (i/3) *3 + j/3;
//                 int l =board[i][j]-'0';
//                 System.out.print(i + "  "+ l);
//                 if(row[i][l] != 0 || col[j][l] !=0 || box[k][l] !=0)
//                     return false;
//                 row[i][l]++;
//                 col[j][l]++;
//                 box[k][l]++;
                
//             }
//         }
//         return true;
        
        
        int N = 9;

        // Use an array to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
        
    }
}
