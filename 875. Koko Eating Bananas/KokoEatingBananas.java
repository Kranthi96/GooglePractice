class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1, r=1;
        for(int i: piles){
             r = Math.max(r,i);
        }
           
        while(l<r){
            int m = (l+r)/2;
            int hours = 0;
            for(int i: piles){
                hours += (i+m-1)/m ;
            }

            if(hours <=h)
                r = m;
            else
                l=m+1;

        }
        return r;
        
    }
}
