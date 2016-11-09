/**
 * 
 */
package interviews;

/**
 * @author Sudhansu
 * [5, 6, 0, 4, 2, 4, 1, 0, 0, 4]
 * 
 * 0, 5, 9, out
 */
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class ArrayHopper {
    public static void main(String args[] ) throws Exception {
      
    	
    	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
       /*
    	BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = br.readLine();
                if(input == null)
                    break;
                list.add(Integer.parseInt(input));
                //System.out.println(input);
            }
          // fetch the value of hops list
          ArrayList<String> outList = findHops(list);
          // if hops list is null then print failure
          if(outList == null)
            System.out.println("failure");
          // else print all the values of hops list and add out to the standard output
          else{
              for(String s: outList){
                  System.out.print(s + ", ");
              }
              System.out.print("out");
          }
      
        } catch (IOException e) {
            e.printStackTrace();
        } 
        */
    	int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    	System.out.println(arrayHopper(arr));
    }
    
    public static ArrayList<String> findHops(List<Integer> array) {
		ArrayList<String> hops = new ArrayList<String>();
		int indexReached = 0, currentIndex = 0, selectedIndex = 0;
		int i;
		for (i = 0; i < array.size(); i++) {
			// check out of bound
			if (!(i <= currentIndex)) 
				break;
			if (i > indexReached) {
                // update current index and add to the hops list
				indexReached = currentIndex;
				hops.add(String.valueOf(selectedIndex));
			}
			int sum = i + array.get(i);
			if (sum > currentIndex) 
				selectedIndex = i;
			currentIndex = Math.max(currentIndex, sum);
		}
        int s = hops.size();
		if ((i > indexReached) && (s > 0) && (selectedIndex != Integer.parseInt(hops.get(s-1)))) {
			hops.add(String.valueOf(selectedIndex));
		}

		if (indexReached >= array.size() - 1)
			return hops;
		else
			return null;
	}
    
    public static int arrayHopper(int []a){
    	if(a.length<=0 || a[0]==0)
    		return Integer.MIN_VALUE;
    	int temp [] = new int [a.length];
    	for(int i = 1;i<a.length; i++){
    		temp[i] = Integer.MAX_VALUE;
    		for(int j = 0; j<i;j++){
    			if(i<=j+a[j] && temp[j]!=Integer.MAX_VALUE){
    				temp[i] = Math.min(temp[j]+1, temp[i]);
    				break;
    			}
    		}
    	}
		System.out.println(Arrays.toString(temp));

		return temp[a.length-1];
    }
}