class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones)
            maxHeap.add(stone);
        while(maxHeap.size() > 1){
            int s1 =maxHeap.remove();
            int s2 = maxHeap.remove();
            if(s1 !=s2)
                maxHeap.add(s1-s2);

        }
       return maxHeap.isEmpty()? 0: maxHeap.remove();
        
    }
}
