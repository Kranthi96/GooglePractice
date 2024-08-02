class Solution {
    public String licenseKeyFormatting(String str, int k) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == '-'){
                continue; 
            } 
            if(counter ==k){ 
                counter =0;
                sb.append('-');
                }
            sb.append(str.charAt(i));
            counter++;
            
        }
        sb.reverse();
        return sb.toString().toUpperCase();

        
    }
}
