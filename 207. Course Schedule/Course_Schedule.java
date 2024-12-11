class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] vert: prerequisites){
            adj.get(vert[1]).add(vert[0]);
            indegree[vert[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }
        int visited = 0;

        while(!q.isEmpty()){
            int n = q.poll();
            visited++;
            for(int node: adj.get(n)){
                indegree[node]--;
                if(indegree[node] == 0)
                    q.offer(node);
            }

        }

        return visited == numCourses;
        
    }
}
