class Snakes_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n*n+1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for(int i=0; i<n; i++){
            columns[i] = i;
        }
        for(int r=n-1; r>=0 ; r--){
            for(int col : columns){
                cells[label++] = new Pair<>(r, col);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n*n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = curr+1; i <= Math.min(curr+6, n*n); i++){
                int row = cells[i].getKey(), col = cells[i].getValue();
                int dest = board[row][col]==-1?i:board[row][col];
                if(dist[dest] == -1){
                    dist[dest] = dist[curr]+1;
                    q.add(dest);
                }
            }
        }
        return dist[n*n];

        
    }
}
