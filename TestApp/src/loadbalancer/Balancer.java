package loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
/**
 * A load balancer, given [(a, 1), (b, 1), (c, 8)], a, b, c means 
 * the machine, 1, 1, 8 means 1/(1+1+8) probability returns a, 
 * 8/(1+1+8) probability return c, write code to implement the balancer. 
 * How would you test it? From http://www.glassdoor.com/Interview/Yelp-Interview-RVW2729615.htm
 * @author sud
 *
 */
public class Balancer {
	long total;
	List<Item> matchList;
	Map<String, Long> weight;
	class Item{
		long min;
		long max;
		String name;
		private Item(long min, long max, String name){
			this.min = min;
			this.max = max;
			this.name = name;
		}
	}
	public Balancer(Map<String, Long> weights){ // {(a, 1), (b, 1), (c, 8)}
		this.weight = weights;
		for(long w: weights.values())
			this.total+=w;	// 10
		populateMatchList();
	}
	private void populateMatchList(){
		matchList = new ArrayList<>(); //	{(0,1,a),(1,2,b),(2,10,c)}
		long cur = 0;
		for(Map.Entry<String, Long> e: this.weight.entrySet()){
			matchList.add(new Item(cur, cur+e.getValue(),e.getKey()));
			cur+=e.getValue();
		}
	}
	public String request(){
		long rand = ThreadLocalRandom.current().nextLong(this.total);
		for(Item i : this.matchList){
			if(rand>=i.min && rand<i.max)
				return i.name;
		}
		return null;
	}
}
