/**
 * 
 */
package random;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class PoweSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> set = new ArrayList<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		System.out.println(Arrays.toString(getPowerSet(set).toArray()));

	}
	/**
	 * Find all subsets of a given set
	 * 
	 */
	
	static ArrayList<ArrayList<String>> getPowerSet(ArrayList<String> set){
		ArrayList<ArrayList<String>> powerSet = new ArrayList<ArrayList<String>>();
		if(set.size()==0){
			return powerSet;
		}
		int setCount = (int)Math.pow(2, set.size());
		
		for (int i = 0; i < setCount; i++) {
			ArrayList<String> subSet = new ArrayList<String>();
			for (int j = 0; j < set.size(); j++) {
				if((i & (1 << j)) > 0){
					subSet.add(set.get(j));
				}
			}
			powerSet.add(subSet);
		}
		return powerSet;
	}
}
