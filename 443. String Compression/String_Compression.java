class String_Compression {
    public int compress(char[] chars) {
        int result = 0;
        int tempCount = 0;
        int prev = 0;
        int left = 0;

        for(int i=0;i<chars.length;i++){
            
            if(chars[prev] == chars[i]){
                tempCount++;
                
            }else{
                result++;
                chars[left++] = chars[prev];
                if(tempCount > 1){
                    String count = tempCount+"";
                    for(char c: count.toCharArray()){
                        chars[left++] = c;
                        result++;
                    }
                }
                tempCount = 1;
                prev = i;
            }
        }
        
        result++;
        chars[left++] = chars[prev];
        if(tempCount > 1){
           String count = tempCount+"";
            for(char c: count.toCharArray()){
                chars[left++] = c;
                result++;
            }
        }
        
        return result;
    }
}
