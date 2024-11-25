class Zigzag_Conversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int charsInSec = 2*(numRows - 1);
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            int t = i;
            while(t < n){
                sb.append(s.charAt(t));
                if(i!=0 && i != numRows-1){
                    int charsInBw = charsInSec - 2 * i;
                    int nextInd = t + charsInBw;
                    if(nextInd < n){
                        sb.append(s.charAt(nextInd));
                    }
                }
                t += charsInSec;

            }

        }
        return sb.toString();
        
    }
}
