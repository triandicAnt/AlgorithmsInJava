public class Q287 {
    public String fractionToDecimal(int num, int den) {
        if(num==0)
            return "0";
        boolean x = (num>=0)?true:false;
        boolean y = (den>=0)?true:false;
        StringBuffer sb = new StringBuffer();
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);
        sb.append((x^y)?"-":"");
        // integer
        sb.append(numerator/denominator);
        numerator%=denominator;
        if(numerator==0)
            return sb.toString();
        
        // fraction;
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(numerator, sb.length());
        while(numerator!=0){
            numerator*=10;
            sb.append(numerator/denominator);
            numerator%=denominator;
            if(map.containsKey(numerator)){
                sb.insert(map.get(numerator), "(");
                sb.append(")");
                break;
            }
            map.put(numerator,sb.length());
        }
        return sb.toString();
    }
}
