class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0? matrix[0].length:0;
        int prev = 0;
        int[] dp = new int[cols + 1];
        int max = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(prev, Math.min(dp[j-1], dp[j])) + 1;
                    max = Math.max(dp[j], max);
                }else{
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return max * max;

        
    }
}
