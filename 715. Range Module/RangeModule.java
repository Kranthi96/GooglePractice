class RangeModule {
    TreeSet<Interval> ranges;

    public RangeModule() {
        ranges = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        while(itr.hasNext()){
            Interval iv = itr.next();
            if(right < iv.left)
                break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv!=null && iv.left <= left && iv.right >= right);
    }
    
    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList<>();
        while(itr.hasNext()){
            Interval iv = itr.next();
            if(right < iv.left)
                break;
            if(iv.left < left)
                todo.add(new Interval(iv.left,left));
            if(iv.right > right)
                todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for(Interval iv: todo){
            ranges.add(iv);
        }
        
    }
}
class Interval implements Comparable<Interval>{
    int left;
    int right;
    public Interval(int left, int right){
        this.left = left;
        this.right = right;
    }

    public int compareTo(Interval inter){
        if(this.right == inter.right)
            return this.left-inter.left;
        return this.right - inter.right;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
