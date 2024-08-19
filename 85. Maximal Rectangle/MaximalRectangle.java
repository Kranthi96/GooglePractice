class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] hist = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                hist[j] = matrix[i][j] == '1' ? hist[j]+1:0;
            }
            ans = Math.max(ans, maxAreaRectInGist(hist));
        }
        return ans;
        
    }

    public int maxAreaRectInGist(int[] heights){
        int max = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                int pse = stack.isEmpty()?-1: stack.peek();
                int nse = i;
                max = Math.max(max, h * (nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse = n;
            int h = heights[stack.pop()];
            int pse = stack.isEmpty()?-1: stack.peek();
            max = Math.max(max, h * (nse-pse-1));
        }
        return max;
    }
}
