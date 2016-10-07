package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("4321"));

	}
    public static int reverse(int x) {
        String s = "";
        boolean flag = false;
        if(x<0){
            flag = true;
            s+= Math.abs(x);
        }else{
            s+=x;
        }
        try{
        String s1 = reverseString(s);
        if(Integer.valueOf(s1)>Integer.MAX_VALUE)
            return 0;
        else{
            int y = Integer.valueOf(s1);
            if(flag){
                return -y;
            }else{
                return y;
            }
        }}
        catch(NumberFormatException e){
            return 0;
        }


        
    }
    public static String reverseString(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            s = swap(s, i,j);
            System.out.println("---"+s);
            i++;
            j--;
        }
        return s;
    }
    public static String swap(String s, int i, int j){
        char [] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
    
}
