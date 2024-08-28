class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr_sum = 0;
        for(int i=0; i< nums.length; i++){
            curr_sum += nums[i];
            max = Math.max(max, curr_sum);
            if( curr_sum < 0)
                curr_sum = 0;
        }
        return max;
    }
}
