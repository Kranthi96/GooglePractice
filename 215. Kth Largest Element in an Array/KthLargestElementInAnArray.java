class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<> (Comparator.reverseOrder());
        int t = k-1;
        for(int i: nums)
            pq.add(i);
        for(int i=0; i<t;i++)
            pq.remove();
        return pq.remove();
    }
}
