/**
 * 
 */
package random;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sudhansu
 *
 */
public class Bucket<T> {

	/**
	 * @param args
	 */
	private Object object;
	public void set(Object object){
		this.object = object;
	}
	public Object get(){
		return object;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bucket<Integer> integerBucket = new Bucket<Integer>();

	}
	public static void methods(List<?> list){
		if(list instanceof ArrayList<?>){
			
		}
	}
	List<String> a = new ArrayList<>();
	ArrayList<String> b = (ArrayList<String>)a;

}
class Parser<T extends Exception>{
	public void parser(File file)throws T{
		
	}
	Map<String, List<String>> m = new HashMap<>();
	public <U> void method(String u){
		
	}
	
}
//Object < Fat < Butter
