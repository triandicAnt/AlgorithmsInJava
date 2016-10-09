package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []a = {-2,-1,0,0,1,2,3};
		findFourSum(a,0);
		
		/**
		 * (2 -1 1 -2), (1 -2 2 -1)
		 */
//		Quadruple q1 = new Quadruple(2 ,-1 ,1 ,-2);
//		Quadruple q2 = new Quadruple(-1,0,0,1);
//		Quadruple q3 = new Quadruple(-2,0,0,2);
//		System.out.println(q1.equals(q2));
//		HashSet<Quadruple> set = new HashSet<Quadruple>();
//		set.add(q1);
//		set.add(q2);
//		set.add(q3);
//		System.out.println(set);

	}
	
	/**
	 * [-2,-1,0,0,1,2] & target = 0
	 * [-2,-1,1,2]
	 * [-1,0,0,1]
	 * [-2,0,0,2]
	 * all possible pair
	 * -3
	 * -2
	 * -1
	 * 0
	 * 1
	 * 2
	 * 3 
	 */
	public static void findFourSum(int [] a, int target){
	/*	HashMap<Pair,Integer> map = new HashMap<>();
		for(int i=0; i<a.length;i++){
			for(int j=0;j<a.length; j++){
				if(i!=j)
				{
					map.put(new Pair(a[i],a[j]), a[i]+a[j]);
				}
			}
		}*/
		HashMap<Integer,Set<Pair>> map = new HashMap<>();
		for(int i=0; i<a.length;i++){
			for(int j=0;j<a.length; j++){
				if(i!=j)
				{
					int val = a[i]+a[j];
					if(map.containsKey(val)){
						Set<Pair> pairs = map.get(val);
						pairs.add(new Pair(i,j));
						map.put(val, pairs);
					}else{
						Set<Pair> list = new HashSet<Pair>();
						list.add(new Pair(i,j));
						map.put(val, list);
					}
				}
			}
		}
		System.out.println(map);
		HashSet<Quadruple> set = new HashSet<Quadruple>();
		// check for target in the array
		for(int x = 0; x<a.length;x++){
			for(int y=0; y<a.length;y++){
				if(x!=y){
					int val = target - (a[x]+a[y]);
					if(map.containsKey(val)){
						Set<Pair> pairSet = map.get(val);
						for(Pair pair: pairSet){
							if(x!=pair.i && x!=pair.j && y!=pair.i && y!=pair.j){
								set.add(new Quadruple(a[x],a[y],a[pair.i], a[pair.j]));
							}
						}
					}
				}
			}
		}
		System.out.println(set);

	}
}
class Pair{
	int i;
	int j;
	public Pair(int i, int j) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.j = j;
	}
	public int hashCode(){
		int [] arr = new int [2];
		arr[0] = this.i;
		arr[1] = this.j;
		Arrays.sort(arr);
		int sum = 0;
		for(int a: arr){
			sum+= a*29;	
		}
		return sum+37;
		
	}
	public boolean equals(Object obj){
		if(obj.getClass()!= Pair.class)
			return false;
		Pair p = (Pair)obj;
		int []arrA = {p.i,p.j};
		int [] arrB = {this.i, this.j};
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		for(int x=0; x<2;x++){
			if(arrA[x]!=arrB[x])
				return false;
		}
		return true;
		
	}
	public String toString(){
		return "("+this.i + " "+ this.j+")";
	}
}
class Quadruple{
	int a;
	int b;
	int c;
	int d;
	public Quadruple(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public int hashCode(){
		int []qArr = new int [4];
		qArr[0] = Math.abs(this.a);
		qArr[1] = Math.abs(this.b);
		qArr[2] = Math.abs(this.c);
		qArr[3] = Math.abs(this.d);
		int sum = 0;
		for(int a:qArr){
			sum+= a*29;	
		}
		return sum+37;
	}
	public boolean equals(Object obj){
		if(obj.getClass()!= Quadruple.class)
			return false;
		Quadruple q = (Quadruple)obj;
//		if(this.a!=q.a || this.b!= q.b || this.c!=q.c || this.d!=q.d)
//			return false;
		int [] arrObj = new int[4];
		arrObj[0] = q.a;
		arrObj[1] = q.b;
		arrObj[2] = q.c;
		arrObj[3] = q.d;
		
		Arrays.sort(arrObj);
		int []qArr = new int [4];
		qArr[0] = this.a;
		qArr[1] = this.b;
		qArr[2] = this.c;
		qArr[3] = this.d;
		Arrays.sort(qArr);
		for(int i=0; i<4;i++){
			if(qArr[i]!=arrObj[i])
				return false;
		}
		return true;
		
	}
	public String toString(){
		return "("+this.a + " "+ this.b+ " " + this.c + " "+ this.d + ")";
	}
	
}