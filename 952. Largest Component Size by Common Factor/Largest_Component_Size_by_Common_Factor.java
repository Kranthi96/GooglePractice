class Largest_Component_Size_by_Common_Factor {
    public int largestComponentSize(int[] nums) {
        int max = Arrays.stream(nums).reduce(nums[0], (x,y) -> x>y ? x : y);
        DisJoinSetUnion dsu = new DisJoinSetUnion(max);
        for(int num : nums){
            for(int i=2; i< ((int)Math.sqrt(num))+1; i++){
                if(num %i == 0){
                    dsu.unionBySize(num, i);
                    dsu.unionBySize(num, num/i);
                }
            }
        }

        int res = 0;
        Map<Integer, Integer> groupCount = new HashMap<>();
        for(int num: nums){
            int id = dsu.findParent(num);
            groupCount.put(id, groupCount.getOrDefault(id, 0)+1);
            res = Math.max(res, groupCount.get(id));
        }

        return res;
        
    }
}
class DisJoinSetUnion{
    int[] size ;
    int[] parent;
    public DisJoinSetUnion(int size){
        this.parent = new int[size+1];
        this.size = new int[size+1];
        for(int i=0;i<=size; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int node){
        if(parent[node] != node)
            parent[node] = this.findParent(parent[node]);
        return parent[node];
    }

    public int unionBySize(int x, int y){
        int px = findParent(x);
        int py = findParent(y);
        if(px == py) return px;
        if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
            return py;
        }
        parent[py] = px;
        size[px] += size[py];
        return px;

    }
}
