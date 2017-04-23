
public class FindAllDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 1, 3, 6, 6};
		printAllDuplicates(arr);
	}
	
	public static void printAllDuplicates(int [] a){
		for(int i = 0;i<a.length;i++){
			if(a[Math.abs(a[i])]>0)
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			else
				System.out.println(Math.abs(a[i]));
		}
	}

}
