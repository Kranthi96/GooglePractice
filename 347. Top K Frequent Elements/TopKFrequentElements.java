class TopKFrequentElements {
    private int[] unique;
    private Map<Integer, Integer> count;

    public void swap(int a, int b){
        unique[a] = (unique[a] + unique[b]) - (unique[b] = unique[a]);
    }

    public int partition(int left, int right, int p){
        int pf = count.get(unique[p]);
        swap(right, p);
        int si = left;

        for(int i=left; i<=right; i++){
            if(count.get(unique[i]) < pf){
                swap(i, si);
                si++;
            }
        }

        swap(si, right);
        return si;
    }

    public void quickSelect(int left, int right, int k){
        if(left == right)
            return;
        Random random = new Random();
        int pi = left + random.nextInt(right-left);

        pi = partition(left, right, pi);
        if(k==pi)
            return;
        else if(k < pi)
            quickSelect(left, pi-1, k);
        else
            quickSelect(pi+1, right, k);
    }


    public int[] topKFrequent(int[] nums, int k) {

        count = new HashMap();
        for(int i: nums)
            count.put(i, count.getOrDefault(i,0)+1);
        int n = count.size();
        unique = new int[n];
        int i=0;
        for(int j: count.keySet())
        {
            unique[i++] = j;
        }
        quickSelect(0, n-1, n-k);
        return Arrays.copyOfRange(unique, n-k, n);
    }
}
