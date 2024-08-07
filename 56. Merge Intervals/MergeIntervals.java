class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->  Integer.compare(a[0],b[0]));
        LinkedList<int[]> ints = new LinkedList<>();
        for(int[] interval: intervals){
            if(ints.isEmpty() || ints.getLast()[1] < interval[0])
                ints.add(interval);
            else
                ints.getLast()[1] = Integer.max(ints.getLast()[1], interval[1]);
            
        }
        return ints.toArray(new int[ints.size()][]);
        
    }
}
