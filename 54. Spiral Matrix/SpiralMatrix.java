class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int top =0, left = 0;
        int right = matrix[0].length-1, bottom = matrix.length-1;
        while(top <= bottom && left <= right){
            for(int j = left; j<=right ; j++)
                result.add(matrix[top][j]);
            top++;
            if(top>bottom) break;
            for(int j= top; j<=bottom; j++)
                result.add(matrix[j][right]);
            right--;
            if(left>right) break;
            for(int j= right; j>= left; j--)
                result.add(matrix[bottom][j]);
            bottom--;
            if(top>bottom) break;
            for(int j = bottom; j>=top ; j--)
                result.add(matrix[j][left]);
            left++;
            if(left>right) break;
        }
        return result;
        
    }
}
