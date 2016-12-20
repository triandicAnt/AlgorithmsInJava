/**
 * 
 */
package random;

/**
 * @author Sudhansu
 *
 */
public class ClassA extends Parent{

	/**
	 * @param args
	 */
	
	public void hello(){
		System.out.println("Hello Child");
	}
	public void fuckOff(){
		System.out.println("you read it!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new ClassA();
		p.hello();
		ClassA a = (ClassA)p;
		a.hello();
		a.fuckOff();
	}

}

class Parent{
	
	public void hello(){
		System.out.println("hello parent");
	}
}