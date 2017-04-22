
public class MaxSumSubMatrix {

	public static void main(String[] args) {
		int [][] a  = new int[][] {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
            };
       findMaxSubMatrix(a);

	}
	
	public static int[] kadane(int[] a){
		int result[] = new int [3];
		result[0] = Integer.MIN_VALUE; // maxsum sum
		result[1] = 0; // start
		result[2] = -1; //end
		int maxSoFar = 0;
		int localStart = 0;
		for(int i = 0; i<a.length;i++){
			maxSoFar = maxSoFar + a[i];
			if(maxSoFar<0){
				maxSoFar = 0;
				localStart = i+1;
			}else if(maxSoFar>a[i]){
				result[0] = maxSoFar;
				result[1] = localStart;
				result[2] = i;
			}
		}
		if(result[2] == -1){
			for(int i =0;i<a.length;i++){
				if(a[i]>result[0]){
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}
		return result;
	}
	 public static void findMaxSubMatrix(int[][] a) {
		 int row = a.length;
		 int col = a[0].length;
		 
		 int left = 0;
		 int top = 0;
		 int right = 0;
		 int bottom = 0;
		 int maxSum = Integer.MIN_VALUE;
		 for(int leftCol = 0; leftCol<col;leftCol++){
			 int []temp = new int[row];
			 for(int rightCol =leftCol;rightCol<col;rightCol++){
				 for(int i = 0; i<row;i++){
					 temp[i]+=a[i][rightCol];
				 }
				 int res[] = kadane(temp);
				 if(res[0]>maxSum){
					 maxSum = res[0];
					 left = leftCol;
					 top = res[1];
					 right = rightCol;
					 bottom = res[2];
				 }
			 }
		 }
		 System.out.println(maxSum + " (" + left + "," + top+")" + "(" + right + "," + bottom+")" );
	 }

}
