class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        for(String s: operations){
            if(s.equals("C")){
                int p = stack.pop();
                ans -= p;
            }
            else if(s.equals("D")){
                int p = stack.peek() * 2;
                stack.push(p);
                ans += p;
            }else if(s.equals("+")){
                int p1 = stack.pop();
                int p2 = stack.peek();
                int p3 = p1+p2;
                stack.push(p1);
                stack.push(p3);
                ans+=p3;
            }else{
                int i = Integer.parseInt(s);
                stack.push(i);
                ans += i;
            }
                
        }

        return ans;


        



        
    }
}
