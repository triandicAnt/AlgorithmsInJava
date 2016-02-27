import java.util.HashMap;


public class InterviewQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewQuestions i = new InterviewQuestions();
		long a[][] = i.fillMatrix(4);
		//i.printMatrix(a);
		int []b = new int[]{1,2,3,4,9,4,7,8};
		for(int j:b){
			i.createList(j);
		}
		i.printLinkedList(i.root);
		MyLinkedList head = i.mergeList(i.root);
		System.out.println();
		i.printLinkedList(head);
		System.out.println();
		int []c =new int []{1,2,4,3,8,9};
		i.printPairs(c, 10);
		

	}
	
	// Apple interview question
	// Given a number n, construct a n*n matrix and fill it
	// in Spiral way.e.g: for n = 4,
/*	0	1	2	3	
	11	12	13	4	
	10	15	14	5	
	9	8	7	6  */
	
	long[][] fillMatrix(int n){
		long [][]a = new long[n][n];
		int r = 0;
		int d = 1;
		int l = 2;
		int u = 3;
		int top_row = 0;
		int bottom_row = n-1;
		int top_col=0;
		int bottom_col=n-1;
		int dir = r;
		long num = 0;
		while(bottom_row>=top_row && bottom_col>=top_col){
			if(dir==r){
				for(int i =top_col; i<=bottom_col;i++){
					a[top_row][i] = num;
					num++;
				}
				dir = d;
				top_row++;
			}
			if(dir==d){
				for(int i =top_row; i<=bottom_row;i++){
					a[i][bottom_col] = num;
					num++;
				}
				dir = l;
				bottom_col--;
			}
			if(dir==l){
				for(int i =bottom_col; i>=top_col;i--){
					a[bottom_row][i] = num;
					num++;
				}
				dir = u;
				bottom_row--;
			}
			if(dir==u){
				for(int i =bottom_row; i>=top_row;i--){
					a[i][top_col] = num;
					num++;
				}
				dir = r;
				top_col++;
			}
		}
		return a;
		
	}
	
	void printMatrix(long[][] mat){
		int rows = mat.length;
		int cols = mat[0].length;
		for(int i=0;i<rows;i++){
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j]+ "\t");
			}
			System.out.println();
		}
	}
	
	// Amazon Interview Question
	/* Given a linked list in which first x elements are in sorted
	 * order and other n-x are also in sorted order. Merge them to 
	 * construct a final linked list. For e.g. 1>2>3>5>9>4>7>8 should
	 * give 1>2>3>4>5>7>8>9.
	 */
	MyLinkedList root;
	MyLinkedList mergeList(MyLinkedList root){
		if(root == null)
			return null;
		MyLinkedList fPointer= root;
		MyLinkedList sPointer = root;
		MyLinkedList current = root;
		while(current!=null){
			if(current.next.data<current.data){
				sPointer = current.next;
				break;
			}
			current = current.next;
		}
		if(sPointer == null)
			return fPointer;
		current.next = null;
		MyLinkedList head = root;
		if(fPointer.data<=sPointer.data){
			head = fPointer;
			fPointer = fPointer.next;
		}
		else{
			head = sPointer;
			sPointer=sPointer.next;
		}
		current = head;
		while(fPointer!=null && sPointer!=null){
			if(fPointer.data<=sPointer.data){
				current.next = fPointer;
				fPointer= fPointer.next;
			}
			else{
				current.next = sPointer;
				sPointer= sPointer.next;
			}
			current = current.next;
		}
		if(fPointer!=null){
			current.next = fPointer;
		}
		if(sPointer!=null){
			current.next = sPointer;
		}
		return head;
	}
	
	void printLinkedList(MyLinkedList root){
		MyLinkedList current = root;
		while(current!=null){
			System.out.print(current.data + ">");
			current = current.next;
		}
	}
	void createList(int data){
		if(root == null){
			root = createNode(data);
			return;
		}
		MyLinkedList current = root;
		while(current.next!=null){
			current = current.next;
		}
		current.next  = createNode(data);

	}

	private MyLinkedList createNode(int data) {
		MyLinkedList node = new MyLinkedList();
		node.data = data;
		node.next = null;
		return node;
	}
	
	// Informatica Interview question
	/* Q1. Give an array, find all pairs which sum up to 10.
	 * For e.g. if array is [1,2,4,3,8,9] , it should print 
	 * 2,8 and 1,9 
	 */
	void printPairs(int [] a, int sum){
		if(a.length<2)
			return;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i:a){
			map.put(i, false);
		}
		for(int i :a){
			if(map.containsKey(sum-i) && !map.get(sum-i)){
				System.out.println(i + " "+ (sum-i));
				map.put(i, true);
			}
		}
	}

}

 class MyLinkedList{
	int data;
	MyLinkedList next;
}
