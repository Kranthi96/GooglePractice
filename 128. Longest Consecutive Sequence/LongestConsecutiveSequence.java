class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums)
            numSet.add(num);
        int longestSeq = 0;
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                int curr = num;
                int currSeq = 1;
                while(numSet.contains(curr+1)){
                    curr += 1;
                    currSeq +=1;
                }
               longestSeq = Math.max(longestSeq, currSeq); 
            }
            
            
        }
        return longestSeq;
        
    }
}
