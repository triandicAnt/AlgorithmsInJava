package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println('C');
		String s = "caaabbbcc";
		System.out.println(getCombination(s));
		System.out.println(getCombination("aa"));
		System.out.println(getCombination("aaaabbbccccddd"));
		System.out.println(getCombination("sabcdabcd"));
		System.out.println(getCombination("aaabc"));
		//abaca;
		/**
		 * a3, b1,c1
		 * ab // a2,c1
		 * abac // a1
		 * abaca
		 */

		System.out.println((int)2.8);

	}
	// rearrange characters of a string such that no two adjacent characters are same
	
	static String getCombination(String str){
		// add the characters of str to HashMap
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : str.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c,1);
			}
		}
		
		// create a max heap : Priority Queue
		PriorityQueue<Letter> pQ = new PriorityQueue<>(new Comparator<Letter>() {
			@Override
			public int compare(Letter l1, Letter l2){
				if(l1.cc>l2.cc){
					return -1;
				}else if(l1.cc < l2.cc){
					return 1;
				}else{
					return 0;
				}
			}
		});
		
		for(Entry<Character, Integer> e : map.entrySet()){
			// check if the value of any key is greater than n/2
			if(e.getValue()>(str.length()/2)+1){
				return "impossible";
			}
			pQ.add(new Letter(e.getKey(), e.getValue()));
		}
		
		System.out.println(pQ);
//		while (pQ.size() > 0) {
//		    System.out.println(pQ.poll().toString());
//		}
		StringBuffer sb = new StringBuffer();
		Letter temp=null;
		while(!pQ.isEmpty()){
			if(!pQ.isEmpty()){
				temp = pQ.poll();
				sb.append(temp.c);
				temp.cc--;
//				if(temp.cc>0){
//					pQ.offer(temp);
//				}
			}
			Letter temp1;
			// check for second char
			if(!pQ.isEmpty()){
				temp1 = pQ.poll();
				sb.append(temp1.c);
				temp1.cc--;
				if(temp1.cc>0){
					pQ.offer(temp1);
				}
			}
			if(temp!=null){
			if(temp.cc>0){
				pQ.offer(temp);
			}}
		}
		return sb.toString();
		

	}
//	syso
	
}

class Letter{
	char c;
	int cc;
	public Letter(char c, int cc) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.cc = cc;
	}
	public int hashCode(){
		return (int)this.c+49;
	}
	public boolean equals(Letter l1, Letter l2){
		return l1.c == l2.c;
	}
	public String toString(){
		return this.c + " " + this.cc;
	}
}
