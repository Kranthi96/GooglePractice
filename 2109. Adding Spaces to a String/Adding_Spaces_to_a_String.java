class Adding_Spaces_to_a_String {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while( i<s.length() && j<spaces.length){
            if(i == spaces[j]){ sb.append(" "); j++;}
            sb.append(s.charAt(i++));
        }
        while(i<s.length()) sb.append(s.charAt(i++));
        return sb.toString();
        
    }
}
