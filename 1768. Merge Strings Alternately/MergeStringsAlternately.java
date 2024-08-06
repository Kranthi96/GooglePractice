class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int i =0, j =0;
        StringBuilder sb = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        while(i< m && j < n){
            if(i< m) sb.append( word1.charAt(i++));
            if(j<n) sb.append( word2.charAt(j++));
            
        }
        sb.append(word1.substring(i));
        sb.append(word2.substring(j));
        return sb.toString();
    }
}
