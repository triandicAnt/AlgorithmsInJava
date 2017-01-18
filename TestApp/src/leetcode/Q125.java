public class Q125 {
    public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty())
            return true;
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)||Character.isLetter(c))
                sb.append(c);
        }
        System.out.println(sb.toString() + " "+ sb.reverse().toString());
        return sb.toString().equals(sb.reverse().toString());
    }
}
