class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> pMap = new HashMap<>();
        for(int[] point : points){
            if(!pMap.containsKey(point[0]))
                pMap.put(point[0], new HashSet<Integer>());
            pMap.get(point[0]).add(point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points.length; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if(x1 != x2 && y1 != y2 && pMap.get(x1).contains(y2) && pMap.get(x2).contains(y1)){
                    ans = Math.min(ans, Math.abs(x1-x2) * Math.abs(y1-y2));
                }

            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}
