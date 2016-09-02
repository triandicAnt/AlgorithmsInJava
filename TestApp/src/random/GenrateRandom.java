package random;
import java.util.Random;


public class GenrateRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randInt(0, 10);

	}

	public static void randInt(int min, int max) {

	    Random rand = new Random();
	    for(int i = 0; i<20;i++){
	    	int randomNum = rand.nextInt((max - min) + 1);
	    	System.out.println(randomNum);
	    }
	}
}
