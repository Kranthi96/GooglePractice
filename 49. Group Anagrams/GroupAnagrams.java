class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<Integer, List> ans = new HashMap<Integer,List>();
        for(String s: strs){
            int[] count = new int[26];
            for(char c: s.toCharArray()) count[c-'a']++;
            int key = Arrays.hashCode(count);
            ans.putIfAbsent(key, new ArrayList());
            ans.get(key).add(s);
            
        }
        return new ArrayList(ans.values());
        
    }
}
