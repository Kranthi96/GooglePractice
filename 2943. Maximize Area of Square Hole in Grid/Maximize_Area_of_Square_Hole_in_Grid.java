class Maximize_Area_of_Square_Hole_in_Grid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxVccount = 1, maxHccount = 1;
        int curr=1;
        for(int i=0; i<hBars.length-1; i++){ 
            if(hBars[i+1] != hBars[i]+1){
                maxHccount = Math.max(maxHccount, curr);
                curr = 0;
            }
            curr++;
        }
        maxHccount = Math.max(maxHccount, curr);
        curr=1;
        for(int i=0; i<vBars.length-1; i++){
            if(vBars[i]+1 != vBars[i+1]){
                maxVccount = Math.max(maxVccount, curr);
                curr = 0;
            }
            curr++;
        }
        maxVccount = Math.max(maxVccount, curr);

        int min = Math.min(maxVccount, maxHccount)+1;
        return min*min;
        
    }
}
