class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                int pse = stack.isEmpty()?-1:stack.peek();
                int nse = i;
                max = Math.max(max, h * (nse-pse-1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int nse = n;
            int h = heights[stack.pop()];
            int pse = stack.isEmpty()?-1:stack.peek();
            max = Math.max(max, h * (nse-pse-1));

        }

        return max;
        
    }
}
