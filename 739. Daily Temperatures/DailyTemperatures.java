class DailyTemperatures {
    public int[] dailyTemperatures(int[] temps) {
        int n= temps.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int curr = temps[i];
            while(!stack.isEmpty() && temps[stack.peek()]<curr ){
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
        
    }
}
