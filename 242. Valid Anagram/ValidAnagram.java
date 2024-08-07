class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // int[] chars = new int[26];
        // if(s.length() != t.length()) return false;
        // for(char c: s.toCharArray()){
        //     int i = t.indexOf(c,chars[c%26]);
        //     if(i==-1)
        //         return false;
        //     chars[c%26] = i+1;
        // }
        // return true;
        
        int[] chars = new int[26];
        if(s.length() != t.length()) return false;
        for(char c: s.toCharArray())
            chars[c-'a']++;
        for(char c: t.toCharArray()){
            chars[c-'a']--;
            if(chars[c-'a']<0)
                return false;
        }
        return true;
        
    }
}
