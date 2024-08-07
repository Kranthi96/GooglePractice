class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left =0, right = nums.length-1;
        int[] ans= new int[right+1];
        int i=right;
        while(left<=right){
            int l = Math.abs(nums[left]);
            int r = Math.abs(nums[right]);
            int n;
            if(l>r){
                n = l*l;
                left++;
            }else{
                n = r*r;
                right--;
            }
            ans[i--]=n;

        }
        return ans;
    }
}
