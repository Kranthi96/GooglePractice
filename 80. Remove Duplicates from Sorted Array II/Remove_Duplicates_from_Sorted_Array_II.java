class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int i = 1, j=1, count =1;
        int n = nums.length;
        while(i<n){
            if(nums[i] == nums[i-1]){
                count++;
                if(count>2){
                    i++;
                    continue;
                }   
            }else{
                count = 1;
            }
            nums[j++] = nums[i++];
        }
        return j;
        
    }
}
