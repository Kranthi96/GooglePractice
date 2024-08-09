class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            switch(s){
                case "+":
                case "-":
                case "*":
                case "/":
                    int op2 = stack.pop();
                    int op1 =stack.pop();
                    if(s.equals("+"))
                        stack.push(op1 + op2);
                    else if(s.equals("-"))
                        stack.push(op1 - op2);
                    else if(s.equals("*"))
                        stack.push(op1 * op2);
                    else if(s.equals("/"))
                        stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop(); 
        
    }
}
