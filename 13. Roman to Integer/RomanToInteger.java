class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0 ;
        int n = s.length();
        for(int i=0; i<n;i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i+1 < n){
                        char c = s.charAt(i+1);
                        if(c == 'V'){ num += 4; i++;}
                        else if(c == 'X'){ num += 9; i++;}
                        else num +=1;
                    }else{
                        num +=1;
                    }
                    break;
                case 'V':
                    num+=5;
                    break;
                case 'X':
                    if(i+1 < n){
                        char c = s.charAt(i+1);
                        if(c == 'L'){ num += 40; i++;}
                        else if(c == 'C'){ num += 90; i++;}
                        else num +=10;
                    }else{
                        num +=10;
                    }
                    break;
                case 'L':
                    num+=50;
                    break;
                case 'C':
                    if(i+1 < n){
                        char c = s.charAt(i+1);
                        if(c == 'D'){ num += 400; i++;}
                        else if(c == 'M'){ num += 900; i++;}
                        else num +=100;
                    }else{
                        num +=100;
                    }
                    break;
                case 'D':
                    num+=500;
                    break;
                case 'M':
                    num+=1000;
                    break;
            }
        }
        return num;
        
    }
}
