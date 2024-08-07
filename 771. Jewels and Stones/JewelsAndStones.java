class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
//         Map<Character, Integer> stoneMap = new HashMap<>();
//         int total = 0;
//         for(char c: stones.toCharArray())
//             stoneMap.put(c, stoneMap.getOrDefault(c,0)+1);
        
//         for(char c: jewels.toCharArray())
//             total += stoneMap.getOrDefault(c,0);
        
//         return total;
        
        Set<Character> Jset = new HashSet();
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
        
    }
}
