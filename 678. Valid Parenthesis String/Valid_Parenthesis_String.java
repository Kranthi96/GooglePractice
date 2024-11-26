class Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
       int n = s.length();
       int[][] memo = new int[n][n];
       for(int[] row: memo)
            Arrays.fill(row, -1);
        return isValid(0, 0, s, memo);
        
    }
    public boolean isValid(int index, int openCount, String str, int[][] memo){
        if(index == str.length())
            return openCount == 0;
        if(memo[index][openCount] != -1)
            return memo[index][openCount] == 1;
        boolean isValid = false;
        if(str.charAt(index) == '*'){
            isValid |= isValid(index+1, openCount+1, str, memo);
            if(openCount > 0)
                isValid |= isValid(index+1, openCount-1, str, memo);
            isValid |= isValid(index+1, openCount, str, memo);
        }else if(str.charAt(index) == '('){
            isValid |= isValid(index+1, openCount+1, str, memo);
        }else if(openCount > 0){
            isValid |= isValid(index+1, openCount-1, str, memo);
        }
        memo[index][openCount] = isValid?1:0;
        return isValid;
        
    }
}
