package array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class HistogramArea {
	public static void main(String[] args) {
		int hist[] = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(largestRectangleArea(hist));
		System.out.println(findHistArea(hist));
	}
	 public static int largestRectangleArea(int[] heights) {
	        Stack<Integer> st = new Stack<Integer>();
	        int l = heights.length;
	        int [] area = new int [l];
	        int t = 0;
	        // calculate left index
	        for(int i = 0; i<l; i++){
	            while(!st.empty()){
	                if(heights[i] <= heights[st.peek()]){
	                    st.pop();
	                }
	                else
	                {
	                    break;
	                }
	            }
	            if(st.empty()){
	                t = -1;
	            }
	            else{
	                t = st.peek();
	            }
	            area[i]  = i-t-1;
	            st.push(i);
	        }
	        // calculate right index
	        for(int i = l-1; i>=0; i--){
	            while(!st.empty()){
	                if(heights[i] <= heights[st.peek()]){
	                    st.pop();
	                }
	                else
	                {
	                    break;
	                }
	            }
	            if(st.empty()){
	                t = l;
	            }
	            else{
	                t = st.peek();
	            }
	            area[i]  += t-i-1;
	            st.push(i);
	        }
	        
	        int max = 0;
	        for (int i =0; i<l; i++){
	            area[i] = heights[i]*(area[i]+1);
	            if(area[i]>max){
	                max = area[i];
	            }
	        }
	        return max;
	    }
	 
	 /**
	  * Add to stack if current values is >= stack.top()
	  * else : keep removing from stack till a number which is smaller than or equal to current is found
	  * calculate area every time you remove :
	  * 	if stack is Empty:
	  * 		area = arr[top]*i
	  * 	else:
	  * 		area = arr[top]*(i-stackTop -1)
	  */
	 static int findHistArea(int [] arr){
		 Stack<Integer> s = new Stack<Integer>();
		 if(arr.length == 0){
			 return 0;
		 } else if(arr.length == 1){
			 return arr[0];
		 }
		 int i;
		 int area = 0;
		 int maxArea = 0;
		 for(i = 0; i<arr.length;){
			if(s.isEmpty() || arr[i] >= arr[s.peek()]){
				s.push(i++);
			}else{
				int top = s.peek();
				s.pop();
				if (s.isEmpty()){
					area = arr[top]*i;
				}
				else{
					area = arr[top]*(i-s.peek()-1);
				}
				if(area>maxArea){
					maxArea = area;
				}
				
			
			}
		 }
			while(!s.isEmpty()){
				int top = s.peek();
				s.pop();
				if(s.isEmpty()){
					area = arr[top]*i;
				}
				else{
					area = arr[top]*(i-s.peek()-1);
				}
				if(area>maxArea){
					maxArea = area;
				}
			}
		return maxArea;

	 }
	
}
