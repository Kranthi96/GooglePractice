class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <2) return s.length();
        Map<Character,Integer> charMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            if(charMap.containsKey(c) && left <=charMap.get(c)){
                left = charMap.get(c)+1;   
            }
            charMap.put(c, right);
            max = Math.max(max, right-left);
        }
        return max+1;   
        
    }
}
