
  class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int i =0;
        StringBuilder sb = new StringBuilder();
        Character prev;
        while(true){
            boolean isMatched = true;
            prev = null;
            for(String s: strs){
                if(s.length() > i){
                    if(prev == null)
                        prev = s.charAt(i);
                    else if(prev != s.charAt(i)){
                        isMatched = false;
                        break;
                    }
                        
                }else{
                    isMatched = false;
                    break;
                }
            }
            if(isMatched) sb.append(strs[0].charAt(i++));
            else break;
        }
        return sb.toString();
        
    }
}
