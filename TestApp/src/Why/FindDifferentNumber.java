
public class FindDifferentNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {1,2,3,6,5,7};
		int b [] = {2,3,1,4,6,5,7};
		System.out.println(findDifferentNumber(a, b));
	}
	public static int findDifferentNumber(int a[], int b[]){
		int x = a[0];
		for(int i = 1;i<a.length;i++)
			x^=a[i];
		for(int i = 0; i<b.length;i++)
			x^=b[i];
		return x;
	}

}
