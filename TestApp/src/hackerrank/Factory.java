/**
 * 
 */
package hackerrank;

/**
 * @author Sudhansu
 *
 */
public class Factory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodFactory ff = new FoodFactory();
		Food f1 = ff.getFood("Meat");
		Food f2 = ff.getFood("Fruit");
		System.out.println(f1.getClass().getName());

		System.out.println(f2.getClass().getName());

	}

}
/*
class Food{
	String name;
	public Food(){
		
	}
	public Food(String name){
		this.name = name;
	}
	public String getName()
    {
		System.out.println("here");
        return this.name;
    }
	public void setName(String name){
		this.name = name;
	}
	public String toString()
	{
	    return getName();
	}
}
class FoodFactory extends Food{
	public Food getFood(String name){
		return new Food(name);
	}
	public String toString()
    {
        return super.toString();
    }
}
*/
 class Meat extends Food {
}
 class Fruit extends Food {
}
 class Food {
	  public void serveFood() {
	    System.out.println("I'm serving " + getClass().getSimpleName());
	  }
	}
 class FoodFactory {

	  public Food getFood(String food) {

	    if ("Meat".equals(food)) {
	      return new Meat();
	    } else if ("Fruit".equals(food)) {
	      return new Fruit();
	    }
	    throw new IllegalArgumentException("No food found with name " + food);
	  }
	}