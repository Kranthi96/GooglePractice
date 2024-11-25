class Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator < 0 ) ^ (denominator < 0))
            sb.append("-");
        long top = Math.abs(Long.valueOf(numerator));
        long bottom = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(top/bottom));
        long rem = top % bottom;
        if(rem == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0){
            if(map.containsKey(rem)){
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(String.valueOf(rem/bottom));
            rem %= bottom;
        }


        return sb.toString();
    }
}
