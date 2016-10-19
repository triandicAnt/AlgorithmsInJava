package leetcode;

public class CountArithmeticP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(a));

	}
	 public static int numberOfArithmeticSlices(int[] A) {
	        if(A.length<3){
	            return 0;
	        }
	       // int d = A[1] - A[0];
	        int count =0;
	        int n = A.length;
	        for (int i = 3; i<=n; i++){
	            for(int j=0;j<=n-i;j++){
	                boolean flag = true;
	                int d = A[j+1]-A[j];
	                for(int k=j+1;k<j+i;k++){
	                    if((A[k]- A[k-1])!=d){
	                        flag = false;
	                        break;
	                    }
	                }
	                if(flag == true){
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
}
