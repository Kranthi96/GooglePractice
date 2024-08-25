class FibonacciNumber {
    public int fib(int n) {
        return fib(n, new HashMap<>());
    }
    public int fib(int n, Map<Integer, Integer> fibMap){
        if(n<=1) return n;
        if(fibMap.containsKey(n)) return fibMap.get(n);
        int f1 = fib(n-1, fibMap);
        int f2 = fib(n-2, fibMap);
        fibMap.put(n, f1 + f2);
        return fibMap.get(n);
    }
}
