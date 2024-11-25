class LFUCache {
    private int capacity;
    private Map<Integer, Pair<Integer, Integer>> cache;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;
    int minf;

    private void insert(int key, int freq, int value){
        cache.put(key, new Pair<>(freq, value));
        freqMap.putIfAbsent(freq, new LinkedHashSet<>());
        freqMap.get(freq).add(key);
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minf = 0;
    }
    
    public int get(int key) {
        Pair<Integer, Integer> freqVal = cache.get(key);
        if(freqVal == null)
            return -1;
        
        final int freq = freqVal.getKey();
        final Set<Integer> keys = freqMap.get(freq);
        keys.remove(key);
        if(keys.isEmpty()){

            freqMap.remove(freq);
            if(minf == freq)
                ++minf;
        }
        final int value = freqVal.getValue();
        insert(key, freq+1, value);
        return value;
        
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        Pair<Integer, Integer> freqValue = cache.get(key);
        if(freqValue != null){
            cache.put(key, new Pair<>(freqValue.getKey(), value));
            get(key);
            return;
        }
        if(capacity == cache.size()){
            final Set<Integer> keys = freqMap.get(minf);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if(keys.isEmpty())
                freqMap.remove(minf);
        }
        minf = 1;
        insert(key, 1, value);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
