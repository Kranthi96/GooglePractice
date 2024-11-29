class Minimum_Time_to_Visit_a_Cell_In_a_Grid {
    private int[][] dirs ={
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int minimumTime(int[][] grid) {
       if(grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[] {grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0], i = curr[1], j = curr[2];
            if(visited[i][j]) continue;
            visited[i][j] = true;
            for(int[] dir: dirs){
                int x = i+dir[0], y = j+dir[1];
                if(!(x>=0 && y>=0 && x<m && y <n && !visited[x][y])) continue;

                int wasteTime = (grid[x][y] - time) % 2 == 0 ? 1 : 0;
                int nextTime = Math.max(grid[x][y] + wasteTime, time +1);
                if(x == m-1 && y == n-1)
                    return nextTime;
                pq.offer(new int[]{nextTime, x, y});
        
            }
        }
        return -1;
    }

}
