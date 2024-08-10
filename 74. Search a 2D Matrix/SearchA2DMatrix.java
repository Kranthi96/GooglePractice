class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = (m*n)-1;
        while(l<=h){
            int p= l+(h-l)/2;
            int r = p/n, c= p%n;
            if(matrix[r][c] == target)
                return true;
            if(matrix[r][c] > target) h = p-1;
            else l = p+1;

        }
        
        return false;
        
    }
}
