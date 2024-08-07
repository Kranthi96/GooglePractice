class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ele = nums[0];
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ele){
                count++;
            }else{
                count--;
                if(count==0){
                    ele = nums[i];
                    count=1;
                }
            }
        }
        return ele;
        
    }
}
