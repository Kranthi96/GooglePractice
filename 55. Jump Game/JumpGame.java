class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0, 0);
    }
    public boolean helper(int[] nums, int i, int rem){
        rem = Math.max(nums[i], rem);
        if(nums.length-1-i <= rem)
            return true;
        if(rem==0)
            return false;
        return helper(nums, i+1, rem-1);
    }
}
