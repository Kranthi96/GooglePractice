class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num <2) return true;
        long l =2, h = num/2, m,mul;
        while(l<=h){
            m = l+(h-l)/2;
            mul = m*m;
            if(mul == num)
                return true;
            if(mul > num)
                h = m-1;
            else
                l = m+1;
            
        }
        return false;

    }
}
