/**
 * 
 */
package random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
class Shape<T>{
	public static void shapeTest(Shape<Fat> n){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape<Butter> b = new Shape<Butter>();
		Shape<Object> o = new Shape<Object>();

		//shapeTest(o);
		List <String>list = new ArrayList<String>();
		Collections.sort(list);
		StringBuffer myText = new StringBuffer();
		myText.append("Hello");
		List<String> myList = new ArrayList<String>();
		myList.add("Hello");
		boolean containsMyText = myList.contains(myText);
		System.out.println(containsMyText);

	}

}

class Fat extends Object{
	
}
class Butter extends Fat {
	
}

	