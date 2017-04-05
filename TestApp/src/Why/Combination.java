import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"hr3a" output all the combination of upper and lower case letters such as {hr3a, hr3A, hR3a, hR3A, hr3a, hr3A, HR3a, HR3A} 
		System.out.println(url("hr3a"));
	}
	public static List url(String s){
		List list = new ArrayList<>(); 
		if(s==null||s.length()==0) 
			return list; 
		helper(s,list,0); return list; 
	} 
	public static void helper(String s, List list, int index){
		if(index==s.length()){
			list.add(s); 
			return; 
		} 
		if(!Character.isAlphabetic(s.charAt(index))){ 
			helper(s.substring(0, index)+Character.toLowerCase(s.charAt(index))+s.substring(index+1),list,index+1);//lower; 
		} else{ 
			helper(s.substring(0, index)+Character.toLowerCase(s.charAt(index))+s.substring(index+1),list,index+1);//lower; 
			helper(s.substring(0, index)+Character.toUpperCase(s.charAt(index))+s.substring(index+1),list,index+1);;//upper; 
			} 
	}
//  [hr3a, hr3A, hR3a, hR3A, Hr3a, Hr3A, HR3a, HR3A]
//	[hr3a, hr3A, hR3a, hR3A, Hr3a, Hr3A, HR3a, HR3A]


}
