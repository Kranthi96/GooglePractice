class Minimum_One_Bit_Operations_to_Make_Integers_Zero {
    public int minimumOneBitOperations(int n) {
        if(n==0)
            return 0;
        int k = 0, curr = 1;
        while(curr * 2 <= n){
            curr *=2;
            k++;
        }
        return (1 << (k+1)) - 1 - minimumOneBitOperations(n ^ curr); 
        
    }
}
