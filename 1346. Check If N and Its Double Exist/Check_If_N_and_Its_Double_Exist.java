class Check_If_N_and_Its_Double_Exist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int n: arr){
            
            if(set.contains(n*2) || ((n%2 == 0) && set.contains(n/2))) return true;
            set.add(n);

        }
        return false;
        
    }
}
