
public class StringMinus {
	static boolean minusFlag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverse("sudhansu"));
		String s1 = "767676777";
		String s2 = "1656556000";
		System.out.println(minus(s1, s2));
	}
	public static String minus(String s1, String s2){
		if(s1==null || s1.length()==0 || s2 == null || s2.length()==0)
			return null;
		if(s1.length()<s2.length() || (s1.length()==s2.length() && s1.compareTo(s2)<0)){
			minusFlag = true;
			return minus(s2,s1);
		}
			
		String n1 = reverse(s1);
		String n2 = reverse(s2);
		int i =0;
		int j = 0;
		int l1 = s1.length();
		int l2 = s2.length();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(i<l1 && j<l2){
			int x = n1.charAt(i++)-48;
			x-=carry;
			carry = 0;
			int y = n2.charAt(j++)-48;
			if(x<y){
				x+=10;
				carry = 1;
			}
			int z = x-y;
			sb.append(z);
		}
		boolean f = false;
		while(i<l1){
			if(!f){
				int x = n1.charAt(i++)-48;
				x-=carry;
				f = true;
				if(x!=0)
					sb.append(x);
			}else
				sb.append(n1.charAt(i++));
		}
		sb=sb.reverse();
		StringBuilder sb2 = new StringBuilder();
		for(char  c : sb.toString().toCharArray()){
            if(!(sb2.length()==0 && c=='0'))
                sb2.append(c);
        }
		if(minusFlag)
			sb2 = sb2.insert(0, '-');
		minusFlag = false;
		return sb2.toString();
	}
	
	// reverse String
	public static String reverse(String s){
		int i =0;
		int j = s.length()-1;
		char [] ca = s.toCharArray();
		while(i<j){
			ca[i]^=ca[j];
			ca[j]^=ca[i];
			ca[i]^=ca[j];
			i++;
			j--;
		}
		return String.valueOf(ca);
	}

}
