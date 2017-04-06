import java.util.ArrayList;
import java.util.List;

public class CapCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"hr3a" output all the combination of upper and lower case letters such as {hr3a, hr3A, hR3a, hR3A, hr3a, hr3A, HR3a, HR3A} 
		String s = "hr3a";
		System.out.println(new CapCombination().getComb(s));

	}
	public List<String> getComb(String s){
		List<String> list = new ArrayList<>();
		if(s==null || s.length()==0)
			return list;
		dfs(s,list,0);
		return list;
	}
	public void dfs(String s, List<String>list, int index){
		if(index==s.length())
		{
			list.add(s);
			return;
		}
		if(!Character.isAlphabetic(s.charAt(index))){
			dfs(s.substring(0, index)+s.charAt(index)+ s.substring(index+1), list,index+1);
		}else{
			dfs(s.substring(0, index)+Character.toLowerCase(s.charAt(index))+ s.substring(index+1), list,index+1); // lower
			dfs(s.substring(0, index)+Character.toUpperCase(s.charAt(index))+ s.substring(index+1), list,index+1); // upper
		}
	}

}
