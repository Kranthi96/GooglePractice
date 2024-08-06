class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
//         int mul = 1;
//         int zeros= 0;
//         for(int n: nums){
//             if(n==0){
//                 zeros++;
//                 continue;
//             }
//             mul *= n;
//         }
//         for(int i=0; i<nums.length;i++){
//             if(zeros == 0){
//                 nums[i] = (mul/nums[i]);
//             }
//             else if(zeros == 1){
//                 if(nums[i] == 0)
//                     nums[i] = mul;
//                 else
//                     nums[i] = 0;
//             }
//             else
//                 nums[i] = 0;
            
//         }
            
        
//         return nums;
        
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0, left =1;i<n;i++){
            ans[i] = left;
            left *=nums[i];
        }
        for(int j=n-1, right =1; j>=0; j--){
            ans[j] *= right;
            right *= nums[j];
        }
        
        return ans;
        
    }
}
