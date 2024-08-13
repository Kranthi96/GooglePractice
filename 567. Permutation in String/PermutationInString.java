class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        // if(s2.length() < s1.length()) return false;
        // HashMap<Character,Integer> s1Map = new HashMap<>();
        // for(char c: s1.toCharArray())
        //     s1Map.put(c,s1Map.getOrDefault(c,0)+1);
        // for(int i=0; i<=s2.length()-s1.length(); i++){
        //     if(s1Map.containsKey(s2.charAt(i))){
        //         HashMap<Character,Integer> s2Map = new HashMap<>();
        //         for(int j=0; j<s1.length(); j++){
        //             char ch = s2.charAt(i+j);
        //             s2Map.put(ch,s2Map.getOrDefault(ch,0)+1);
        //         }
        //         if(s1Map.equals(s2Map)) return true;
        //     }
           
        // }
        // return false;
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i=0 ;i<l1;i++)
        {
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }
        int count =0;
        for(int i=0; i<26;i++) if(s1Map[i] == s2Map[i]) count++; 
        for(int i = l1; i<l2; i++){
            if(count == 26)
                return true;
            int leftRem = s2.charAt(i-l1)-'a';
            int rightAdd = s2.charAt(i)-'a';
            s2Map[rightAdd]++;
            if(s1Map[rightAdd] == s2Map[rightAdd]) count++;
            else if(s1Map[rightAdd]+1 == s2Map[rightAdd]) count--;

            s2Map[leftRem]--;
            if(s1Map[leftRem] == s2Map[leftRem]) count++;
            else if(s1Map[leftRem]-1 == s2Map[leftRem]) count--;

        }

        return count == 26;

        
    }
}

    
