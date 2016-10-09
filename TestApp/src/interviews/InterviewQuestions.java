package interviews;
import java.util.HashMap;


import com.datastructure.LinkedList;
import com.datastructure.MyLinkedList;
public class InterviewQuestions extends MyLinkedList{

	/**
	 * @param args
	 */
	LinkedList root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewQuestions i = new InterviewQuestions();
		long a[][] = i.fillMatrix(4);
		//i.printMatrix(a);
		MyLinkedList m = new MyLinkedList();
		int []b = new int[]{1,2,3,4,9,4,7,8};
		for(int j:b){
			m.createList(j);
		}
		m.printLinkedList(m.root);
		LinkedList head = i.mergeList(i.root);
		System.out.println();
		i.printLinkedList(head);
//		System.out.println();
//		int []c =new int []{1,2,4,3,8,9};
//		i.printPairs(c, 10);
//		i.findFirstAndSecondLargest(c);
		
		
		int d[] = new int[]{2,4,1,5,7,4,9};
		BinaryTree bt = new BinaryTree();
		
		for(int p : d){
			bt.addRecursive(p);
		}
		bt.inOrder(bt.root);
		

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
	LinkedList mergeList(LinkedList root){
		if(root == null)
			return null;
		LinkedList fPointer= root;
		LinkedList sPointer = root;
		LinkedList current = root;
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
		LinkedList head = root;
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
	/*
	 * Q2. Find the first and second largest number in an array.
	 */
	void findFirstAndSecondLargest(int a[]){
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for(int i : a){
			if(i>first && i>second){
				second = first;
				first = i;
			}
			else if(i>second){
				second = i;
			}
		}
		System.out.println(first + " " + second);
	}
	/*
	 * Q3. Add Method of binary tree insertion.
	 */

}


 
 class BTNode{
		int data;
		BTNode left;
		BTNode right;
	}
 
 class BinaryTree{
	 BTNode root;
	 
	 private BTNode createNode(int data){
			BTNode newNode = new BTNode();
			newNode.data = data;
			newNode.left = newNode.right = null;
			return newNode;
		}
		void inOrder(BTNode root){
			if(root==null)
				return;
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	 private void add(int value){
			if(root==null)
				root = createNode(value);
			else{
				BTNode temp = root;
				BTNode parent = root;
				while(temp!=null){
					if(temp.data>=value){
						parent = temp;
						temp =temp.left;
					}
					else{
						parent = temp;
						temp = temp.right; 
					}
				}
				if(value<=parent.data){
					parent.left = createNode(value);
				}
				else{
					parent.right = createNode(value);
				}
			}
			
		}
		void addRecursive(int value){
			root = addRecursive(root, value);
		}
		private BTNode addRecursive(BTNode root, int data){
			if(root == null){
				root = createNode(data);
				return root;
			}
			if(data<=root.data){
				root.left =  addRecursive(root.left, data);
			}
			else{
				root.right =  addRecursive(root.right, data);
			}
			return root;
		}
 }
