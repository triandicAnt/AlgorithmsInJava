
public class Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s = {"aab","aa"};
		System.out.println(longestCommonPrefix(s));
		//System.out.println("aab".indexOf("ab"));

	}
	  public static String longestCommonPrefix(String[] strs) {
	         if(strs==null || strs.length==0)
	            return "";
	         String pre = strs[0];
	         for(int i = 1;i<strs.length;i++){
	             while(strs[i].indexOf(pre)!=0){
	            	 //System.out.println(strs[i].indexOf(pre) + " " +pre);
	                pre = pre.substring(0,pre.length()-1);
	             }
	         }
	         return pre;
	    }

}
