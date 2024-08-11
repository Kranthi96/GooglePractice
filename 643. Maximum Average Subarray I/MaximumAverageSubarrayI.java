class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        // double ans= Integer.MIN_VALUE;
        // double sum =0;
        // for(int r=0, l=0; r<nums.length; r++){
        //     sum+=nums[r];
        //     if(r<k-1)
        //         continue;
        //     else{
        //         ans = Math.max(ans, sum/k);
        //         sum -= nums[l++];
        //     }
        // }
        // return ans;

        int sum=0;
        for(int i=0;i<k;i++)
            sum +=nums[i];
        int maxSum = sum;
        for(int r=k; r<nums.length; r++){
            sum += nums[r]-nums[r-k];
            maxSum = Math.max(maxSum,sum);
        }
        return (double)maxSum/k;
        
    }
}
