class Meeting_Rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length ==0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(intervals.length, (a,b)->{return a-b;});
        Arrays.sort(intervals, (a,b)->{return a[0] - b[0];});
        queue.add(intervals[0][1]);
        for(int i=1; i<intervals.length;i++){
            if(queue.peek() <= intervals[i][0])
                queue.poll();
            queue.add(intervals[i][1]);
        }

        return queue.size();
        
    }
}
