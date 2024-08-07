class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
//         if(ransomNote.length() > magazine.length())
//             return false;
//         Map<Character, Integer> mMap = new HashMap<>();
//         boolean isPossible = true;
//         for(char c: magazine.toCharArray())
//             mMap.put(c, mMap.getOrDefault(c,0)+1);
        
//         for(char c: ransomNote.toCharArray()){
//             if(!mMap.containsKey(c)){
//                 isPossible = false;
//                 break;
//             }
//             int count = mMap.get(c);
//             count--;
//             if(count ==0)
//                 mMap.remove(c);
//             else
//                 mMap.put(c,count);
//         }
//         return isPossible;
        
        int[] chars = new int[26];
        for(char c: ransomNote.toCharArray()){
            int i = magazine.indexOf(c, chars[c%26]);
            if(i == -1)
                return false;
            chars[c%26] = i+1;
        }
        return true;
    }
}
