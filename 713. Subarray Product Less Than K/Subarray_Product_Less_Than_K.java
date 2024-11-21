class Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int count = 0;
        int l = 0;
        for(int r= 0; r<nums.length; r++){
            prod *= nums[r];
            while(prod >=k && l < r)
                prod /= nums[l++];
                
            if(prod < k){
                count += r-l+1;
            }
        }
        return count;
        
    }

}
