class Find_Minimum_Diameter_After_Merging_Two_Trees {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        List<List<Integer>> gr1 = getAdjList(edges1);
        List<List<Integer>> gr2 = getAdjList(edges2);
        int[] gr1_ex = new int[] {Integer.MIN_VALUE, -1};
        int[] gr2_ex = new int[] {Integer.MIN_VALUE, -1};
        int gr1_dia = Integer.MIN_VALUE;
        int gr2_dia = Integer.MIN_VALUE;
        int gr1_cen = 0;
        int gr2_cen = 0;
        gr1_ex = getExtrmeNode(gr1, -1, 0, 0, gr1_ex);
        gr1_ex = getExtrmeNode(gr1, -1, gr1_ex[1], 0, gr1_ex);
        gr1_dia = gr1_ex[0];
        gr1_cen = (gr1_dia %2 == 0) ? gr1_dia/2 : (gr1_dia+1)/2 ;
   


        gr2_ex = getExtrmeNode(gr2, -1, 0, 0, gr2_ex);
        gr2_ex = getExtrmeNode(gr2, -1, gr2_ex[1], 0, gr2_ex);
        gr2_dia = gr2_ex[0];
        gr2_cen = (gr2_dia %2 == 0) ? gr2_dia/2 : (gr2_dia+1)/2 ;


        return Math.max(Math.max(gr1_dia, gr2_dia), gr1_cen + gr2_cen + 1);
        
    }

    public List<List<Integer>> getAdjList(int[][] edges){
        int n = edges.length+1;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i< n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    } 


    public int[] getExtrmeNode(List<List<Integer>> graph, int par, int node, int dis, int[] res){
        if(dis > res[0]){
            res[0] = dis;
            res[1] = node;
        }
        for(int adjNode: graph.get(node)){
            if(par != adjNode)
                res = getExtrmeNode(graph, node, adjNode, dis+1, res);
        }

        return res;
    }
}
