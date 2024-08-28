class HouseRobber {
    Map<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    public int helper(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }
        if(map.containsKey(i)) return map.get(i);
        int res = Math.max(helper(nums, i+1), helper(nums,i+2)+nums[i]);
        map.put(i, res);
        return map.get(i);
    }
}
