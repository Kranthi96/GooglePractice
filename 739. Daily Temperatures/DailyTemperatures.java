class Solution {
    public int[] dailyTemperatures(int[] temps) {
        // int n= temps.length;
        // int[] ans = new int[n];
        // Deque<Integer> stack = new ArrayDeque<>();
        // for(int i=0;i<n;i++){
        //     int curr = temps[i];
        //     while(!stack.isEmpty() && temps[stack.peek()]<curr ){
        //         int prev = stack.pop();
        //         ans[prev] = i - prev;
        //     }
        //     stack.push(i);
        // }
        // return ans;

        int n = temps.length;
        int[] ans = new int[n];
        int max = 0;
        for(int i=n-1; i>=0; i--){
            int curr = temps[i];
            if(max <= curr){
                max = curr;
                continue;
            }
            int days = 1;
            while(temps[i+days] <= curr){
                days += ans[i+days];
            }
            ans[i]= days;
        }
        return ans;

        
    }
}

