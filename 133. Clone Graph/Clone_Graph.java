/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Clone_Graph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Node, Node> cloneMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(visited.contains(n))
                continue;
            visited.add(n);
            cloneMap.putIfAbsent(n, new Node(n.val));
            Node cNode = cloneMap.get(n);
            List<Node> cNbrs = cNode.neighbors;
            for(Node nbr: n.neighbors){
                cloneMap.putIfAbsent(nbr, new Node(nbr.val));
                cNbrs.add(cloneMap.get(nbr));
                 queue.add(nbr);
            }
        }
        return cloneMap.get(node);
    }
}
