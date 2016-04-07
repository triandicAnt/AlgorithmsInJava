/**
 * 
 */
package random;

/**
 * @author Sudhansu
 *
 */
public class UtopianTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtopianTree u = new UtopianTree();
		u.findHeight(15);
		System.out.println("avbdsfsf".substring(0,0));
		String s = "abc";
		u.permute(s);

	}
	void findHeight(int cycle){
		int height = 1;
		if(cycle ==0)
		{
			System.out.println(height);
			return;
		}
		
		while(cycle>0){
			if(cycle>0)
				height = 2*height;
			cycle --;
			if(cycle>0)
				height++;
			cycle--;
		}
		System.out.println(height);

	}
	/**
	 * String permutation
	 * @param str
	 */
	void permute(String str){
		permute("", str);
	}
	void permute(String pre, String str){
		if(str.length()==1)
			System.out.println(pre+str);
		else{
			for (int i = 0; i < str.length(); i++) {
				permute(pre+str.charAt(i), str.substring(0,i)+str.substring(i+1,str.length()));
			}
		}
	}
}
