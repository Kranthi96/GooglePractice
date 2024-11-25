class Lexicographically_Smallest_String_After_Operations_With_Constraint {
    public String getSmallestString(String s, int k) {
        if(k==0)
            return s;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(k==0){
                sb.append(c);
                continue;
            }
            int fdist = 'z'-c+1;
            int bdist = c - 'a';
            int min = Math.min(fdist, bdist);
            if( min > k){
                sb.append((char)(c-k));
                k=0;
            }else{
                sb.append('a');
                k -= min;
            }
        }
        return sb.toString();
        
        
        
    }
}
