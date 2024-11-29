class Minimum_Obstacle_Removal_to_Reach_Corner {
    private final int[][] dirs ={
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minObst = new int[m][n];
        for(int[] obst : minObst){
            Arrays.fill(obst, Integer.MAX_VALUE);
        }
        minObst[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0});
        while(!dq.isEmpty()){
            int[] curr = dq.poll();
            int dis = curr[0];
            int i = curr[1];
            int j = curr[2];
            for(int[] dir: dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                if(isValid(grid, x, y) && minObst[x][y] == Integer.MAX_VALUE){
                    if(grid[x][y] == 1){
                        minObst[x][y] = dis + 1;
                        dq.addLast(new int[]{dis+1, x, y});
                    }else{
                        minObst[x][y]=dis;
                        dq.addFirst(new int[]{dis, x,y});
                    }
                }
            }
        }





    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

    //     pq.add(new int[] {minObst[0][0], 0, 0});
    //     while(!pq.isEmpty()){
    //         int[] node = pq.poll();
    //         int dist = node[0];
    //         int row = node[1];
    //         int col = node[2];
    //         if(row == m-1 && col == n-1)
    //             return dist;
    //         for(int[] dir: dirs){
    //             int x= row+dir[0], y = col+dir[1];
    //             if(isValid(grid, x, y)){
    //                 int new_dist = dist + grid[x][y];
    //                 if(new_dist < minObst[x][y]){
    //                     minObst[x][y] = new_dist;
    //                     pq.add(new int[] {new_dist, x, y});
    //                 }
    //             }    
    //         }

    //     }
       return minObst[m-1][n-1];
        
    }
     private boolean isValid(int[][] grid, int x, int y){
            return (x>=0 && y>=0 && x<grid.length && y<grid[0].length);
        }

}
