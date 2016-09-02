package array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


class Node{
	int data;
	Node left;
	Node right;
}
public class RemoveDup {

	/**
	 * @param args
	 */
	static{
		System.out.println("Hello Static");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,0,3,5,4,6,8,9};
		//int[] b = removeDup(a);
//		System.out.println(Arrays.toString(b));
//		printPrime(10);
//		System.out.println();
//		printPrimeFactors(6);
		//findOccurence("aasddsdsd");
//		System.out.println(getSecondLargest(a));
//		sortArray(a);
//		System.out.println(Arrays.toString(a));
//		System.out.println(checkSum2(a, 10));
		System.out.println(reverseString1("sudhansu"));
		System.out.println(51|1);

	}
	 static int[] removeDup(int [] a){
		 Set<Integer> newSet = new HashSet<Integer>();
		 for (int i: a)
			 newSet.add(i);
		 int i = 0;
		 int [] newArray = new int[newSet.size()];
		 for (Iterator<Integer> it = newSet.iterator(); it.hasNext();) {
			 newArray[i++] = it.next();
		    }
		    return newArray;
		 
	 }
	 
	 static void printPrime(int num){
		 for(int i = 2; i<=num;i++){
			 boolean flag = false;
			 for(int j = 2;j*j<=i;j++){
				 if(i%j==0)
				 {
					 flag = true;
					 break;
				 }
			}
			 if(!flag)
				 System.out.print(i + " ");
			 }
		 }
	 
	 static void printPrimeFactors(int num){
		 while(num%2==0){
			 System.out.print(2 + " ");
			 num = num/2;
		 }
		 for(int i = 3; i*i<=num; i= i+2){
			 if(num%i==0){
				 System.out.print(i + " ");
				 num = num/i;
			 }
		 }
		 if(num>2)
			 System.out.print(num);
	}
	 static void findOccurence(String str){
		 if(str == null) return;
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 char [] ch = str.toCharArray();
		 for(char c: ch){
			 if(map.containsKey(c)){
				 int val = map.get(c);
				map.put(c,val+1);
			 }
			 else{
				 map.put(c, 1);
			 }
			 
		 }
//		 System.out.println(map.toString());
//		 for(Iterator<Entry<Character, Integer>> it = map.)
		 for(Character c: map.keySet()){
			 System.out.println(c + " " + map.get(c));
		 }
		 for(Map.Entry<Character, Integer> entry: map.entrySet()){
			 Character c = entry.getKey();
			 Integer i = entry.getValue();
			 System.out.println(c + " " +i);
		 }
	 }
	 
	 static int getSecondLargest(int [] a){
		 int first = Integer.MIN_VALUE;
		 int second = Integer.MIN_VALUE;
		 for(int i = 0; i<a.length;i++){
			 if(a[i]>first && a[i]> second){
				 second = first;
				 first = a[i];
			 }
			 else if(a[i]>second){
				 second = a[i];
			 }
		 }
		 return second;
	 }
	 static void sortArray(int a[]){
		  Arrays.sort(a);
	 }
	 static boolean checkSum(int a[], int sum){
		 HashSet<Integer> set = new HashSet<>();
		 for (Integer integer : a) {
			set.add(integer);
		}
		 for (Integer integer : a) {
			if(set.contains(sum-integer)){
				return true;
			}
		}
		 return false;
	 }
	 static boolean checkSum2(int a[], int sum){
		 Arrays.sort(a);
		 int i = 0, j = a.length-1;
		 while(i<j){
			 if(sum == a[i]+a[j]){
				 return true;
			 }
			 else if(a[i] + a[j]>sum){
				 j--;
			 }
			 else{
				 i++;
			 }
		 }
		 return false;
	 }
	 static String reverseString(String str){
		 if (str == null || str.length() == 1) return str;

		 int n = str.length();
		 char [] ch = str.toCharArray();
		 for(int i = 0;i<n/2;i++){
			 char temp = ch[i];
			 ch[i] = ch[n-i-1];
			 ch[n-i-1] = temp;
		 }
		 return new String(ch);
	 }
	 static String reverseString1(String str){
		 if (str == null || str.length() == 1) return str;
		 char [] ch = str.toCharArray();
		 Stack<Character> s = new Stack<Character>();
		 
		 for(Character c : ch){
			 s.push(c);
		 }
		 StringBuffer string1 = new StringBuffer();
		 while(!s.isEmpty()){
			 string1 = string1.append(s.pop());
		 }
		 return string1.toString();
	 }
	 
	 void interativeInOrder(Node root)
	 {
	 	if (root == null)
	 		return ;
	 	Node current = root;
	 	boolean done = false;
	 	Stack<Node> s = new Stack<Node>();
	 	while(!done){
	 		if(current!=null){
	 			s.push(current);
	 			current = current.left;
	 		}
	 		else{
	 			if(!s.isEmpty()){
	 				current = s.pop();
	 				System.out.println(current.data);
	 				current = current.right;
	 			}
	 			else{
	 				done = true;
	 			}
	 		}
	 	}
	 }
}

class A3{
	  static{
	  System.out.println("static block is invoked");
	  System.exit(0);
	  }
	}
