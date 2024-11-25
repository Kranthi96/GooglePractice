class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        // int l = -1;
        // for(int i=0;i<nums.length; i++){
        //     if(l != -1 && nums[i] != 0){
        //         nums[l++] = nums[i];
        //         nums[i] = 0;
        //     }
        //     else if(nums[i] == 0 && l==-1){
        //         l = i;
        //     }
        // }
        int l = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                nums[l++] = nums[i];
            }
        }
        for(int i=l; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
