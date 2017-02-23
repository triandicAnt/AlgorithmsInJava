public class NumberToWords {
    
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
    
        int i = 0;
        String words = "";
        
        while (num > 0) {
            if (num % 1000 != 0)
        	    words = helper(num % 1000) +THOUSANDS[i] + " " + words;
        	num /= 1000;
        	i++;
        }
        
        return words.trim();
    }
    
    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
    
    /*
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        String[] base = new String [] {"", " Thousand", " Million", " Billion"};
        String[] teen = new String[]{" Ten", "Eleven", " Twelve"," Thirteen", " Fourteen", " Fifteen" , " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[]ty = new String[]{" ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        String [] digit = new String []{"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        StringBuffer sb = new StringBuffer();
        int c = 0;
        while(num>0){
            String s = "";
            int x = num%1000;
            if(x<10){
                s = digit[x];
            }else if(x<20){
                s = teen[x%10];
            }else if(x<100){
                s = ty[x/10] + digit[x%10];
            }else if(x<1000){
                s = digit[x/100] + " Hundred " ;
                if(x%100!=0)
                    s += numberToWords(x%100);
            }
            sb.insert(0,s + base[c++]);
            num/=1000;
        }
        String temp = new String(sb.toString());
        return sb.toString().trim().replaceAll(" +", " ");
    }
    */
}
