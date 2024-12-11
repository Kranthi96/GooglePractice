class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = getAdjList(numCourses, prerequisites, inDegree);
        Queue<Integer> q = new LinkedList<>();
         for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0) q.offer(i);
         }

        // IntStream.range(0, numCourses).parallel().forEach(i -> { if(inDegree[i] == 0) q.offer(i); });
        List<Integer> result = new LinkedList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);
            for(int adjNode : adj.get(curr)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0)
                    q.offer(adjNode);
            }
        }

        
        return result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }

    public List<List<Integer>> getAdjList(int n, int[][] arr, int[] inDegree){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        // IntStream.range(0, n).parallel().forEach(a -> adj.add(new ArrayList<>()));
        for(int[] pair: arr){
            adj.get(pair[1]).add(pair[0]);
            inDegree[pair[0]]++;
        }
        return adj;
    }
}
