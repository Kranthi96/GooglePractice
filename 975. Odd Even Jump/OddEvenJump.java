class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length; 
        if(n==1) return 1;
        
        int result = 1;
        Boolean[] lower = new Boolean[n];
        Boolean[] higher = new Boolean[n];
        TreeMap<Integer, Integer> arrMap = new TreeMap<Integer,Integer>();
        arrMap.put(arr[n-1],n-1);
        lower[n-1] = true;
        higher[n-1] = true;
        for(int i=n-2; i>=0; i--){
            higher[i] = false;
            lower[i] = false;
            Map.Entry<Integer, Integer> ceiling = arrMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> floor = arrMap.floorEntry(arr[i]);
            if(ceiling != null){
                higher[i] = lower[(int)ceiling.getValue()];
            }
            if(floor != null){
                lower[i] = higher[(int)floor.getValue()];
            }
            if(higher[i]) result++;
            arrMap.put(arr[i],i);
        }
        return result;
        
    }
}
