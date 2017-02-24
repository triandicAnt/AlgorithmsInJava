public class RomanToInt {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        int res = 0;
        int n = s.length();
         for(int i = n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c == 'I'){
                    res+= res>=5?-1:1;
            }else if(c == 'V'){
                    res+= 5;
            }else if(c == 'X'){
                    res+= 10*(res>=50?-1:1);
            }else if(c == 'L'){
                    res+= 50;
            }else if(c == 'C'){
                    res += 100*(res>=500?-1:1);
            }else if(c == 'D'){
                    res+= 500;
            }else if(c == 'M'){
                    res+= 1000;
            }
        }
        
        /*
        for(int i = n-1;i>=0;i--){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    res+= res>=5?-1:1;
                    break;
                case 'V':
                    res+= 5;
                    break;
                case 'X':
                    res+= 10*(res>=50?-1:1);
                    break;
                case 'L':
                    res+= 50;
                    break;
                case 'C':
                    res += 100*(res>=500?-1:1);
                    break;
                case 'D':
                    res+= 500;
                    break;
                case 'M':
                    res+= 1000;
                    break;
                    
            }
        }
        */
        return res;
    }
}
