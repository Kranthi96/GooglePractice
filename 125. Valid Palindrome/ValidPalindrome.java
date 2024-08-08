class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l =0, h = s.length()-1;
        s = s.toLowerCase();
        while(l<=h){
            while(l<h && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while(l<h && !Character.isLetterOrDigit(s.charAt(h)))
                h--;
            if(s.charAt(l++) != s.charAt(h--) ){
                return false;
            }
                
        }
        return true;
        
    }
}
