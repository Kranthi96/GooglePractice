class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
     
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[left] <=nums[mid]){
                if(target > nums[mid] || nums[left] > target)
                    left= mid+1;
                else
                    right = mid-1;
            }else{
                if(target < nums[mid] || nums[right] < target)
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
        
    }
}
