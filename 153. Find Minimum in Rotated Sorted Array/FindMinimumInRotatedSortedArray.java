class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l=0, h = nums.length-1;
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[h]) return nums[0];
        while(l<=h){
            int m= l+(h-l)/2;
            if(nums[m]> nums[m+1])
                return nums[m+1];
            if(nums[m-1] > nums[m])
                return nums[m];
            if(nums[m] > nums[0])
                l = m+1;
            else{
                h = m-1;
            }
            
        }
        return Integer.MAX_VALUE;
        
    }
}
