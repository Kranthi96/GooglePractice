class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left =0,right=0;
        int curr_sum = 0;
        while(right<n){
            curr_sum += nums[right];
            right++;;
            while(curr_sum >= target){
                res = Math.min(res, right-left);
                curr_sum -= nums[left++];
            }
        }
        return (res==Integer.MAX_VALUE)? 0: res;
        
    }
}
