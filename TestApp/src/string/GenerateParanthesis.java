package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(generateParenthesis(3));
	}
	public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        dfs1(list, str, 0,0, n);
        //dfs(list, str, n,n);        
        // for (int i = 1; i <= n; i++) {
        //     dfs(list, str, 0,0,i);
        // }
        return list;
    }
   public static void dfs(ArrayList<String> list, String str, int l, int r){
        if(l>r)
            return;
        if(l==0 && r==0){
            list.add( str);
            return;
        }
        if(l>0){
            dfs(list,  str+"(", l-1,r);
        }
        if(r>0){
            dfs(list , str + ")" , l, r-1);
        }
    }
     public static void dfs1(ArrayList<String> list, String str, int l, int r, int n){
    	if(l<r)
    		return;
      if(l==n && r==n){
          list.add(str);
      }else{
          if(l<n)
            dfs1(list, str + "(", l+1,r, n);
          if(r<n)
            dfs1(list, str+")", l, r+1, n);
      }
     }

}
