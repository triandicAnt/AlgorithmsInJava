import java.util.*;


public class IsItPossible {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isItPossible(1, 4, 5, 9));

	}
	static public class MyPair
	{
	    private final Integer key;
	    private final Integer value;

	    public MyPair(Integer aKey, Integer aValue)
	    {
	        key   = aKey;
	        value = aValue;
	    }

	    public Integer key()   { return key; }
	    public Integer value() { return value; }
	}
	static LinkedList<MyPair> pairs = new LinkedList<MyPair>();
    public static <pairs> String isItPossible(Integer a, Integer b, Integer c, Integer d){
    	pairs.addLast(new MyPair(a,b));
        while (!pairs.isEmpty()){
        	MyPair pair = pairs.poll();
            Integer key = pair.key();
            Integer value = pair.value();
            if(key.equals(c) &&
                    value.equals(d)){
                return "YES";
            }
            int sum=key+value;
            if (sum<=c){
            	System.out.println("here");
                pairs.addLast(new MyPair(sum,value));
            }
            if (sum<=d){
                pairs.addLast(new MyPair(key,sum));
            }
 
        }
 
        return "NO";
    }

}
