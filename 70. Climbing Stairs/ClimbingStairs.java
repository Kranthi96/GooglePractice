class ClimbingStairs {
    public int climbStairs(int n) {
        return helper(n, new HashMap<Integer, Integer>());
    }

    public int helper( int n, Map<Integer, Integer> stMap){
        if(n<=2) return n;
        if(stMap.containsKey(n)) return stMap.get(n);
        int h1 = helper( n-1, stMap);
        int h2 = helper( n-2, stMap);
        stMap.put(n, h1+h2);
        return stMap.get(n);
    }
}
