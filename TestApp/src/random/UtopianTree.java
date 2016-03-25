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
}
