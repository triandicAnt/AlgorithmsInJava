import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BTNode{
	int data;
	BTNode left;
	BTNode right;
}
public class BinaryTree {

	/**
	 * @param args
	 */

	private BTNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[]{2,4,1,5,7,4,9};
		BinaryTree bt = new BinaryTree();
		
		for(int i : a){
			//add(i);
			bt.addRecursive(i);
		}
		//System.out.println(root.data);
//		bt.inOrder(bt.root);
		//bt.inOrderIterative(bt.root);
		bt.bfs(bt.root);
		System.out.println();
		bt.postOrder(bt.root);
		System.out.println();
		bt.preOrderIterative(bt.root);
		System.out.println();
		System.out.println(bt.findSum(bt.root));
		System.out.println(bt.countTree(3));

	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	private BTNode createNode(int data){
		BTNode newNode = new BTNode();
		newNode.data = data;
		newNode.left = newNode.right = null;
		return newNode;
	}
	private void inOrder(BTNode root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
		System.out.println();
	}
	int sum = 0;
	private int findSum(BTNode root){
		if(root == null){
			return 0;
		}
		findSum(root.left); 
		sum = sum+root.data;
		findSum(root.right);
		return sum;
	}
	private int countTree(int num){
		if(num==0 || num ==1)
			return 1;
		int sum = 0;
		for(int i = 1;i<=num;i++){
			int leftCount = countTree(i-1);
			int rightCount = countTree(num-i);
			sum = sum + leftCount*rightCount;
		}
		return sum;
	}
	private void inOrderIterative(BTNode root){
		if(root == null)
			return;
		Stack<BTNode> s = new Stack<>();
		
		while(true){
			while(root!=null){
				s.push(root);
				root = root.left;
			}
			if(s.isEmpty())
				break;
			root = s.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}
	}
	private void preOrderIterative(BTNode root){
		if(root == null)
			return;
		Stack<BTNode> s = new Stack<>();
		
		while(true){
			while(root!=null){
				System.out.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			if(s.isEmpty())
				break;
			root = s.pop();
			root = root.right;
		}
	}
	private void postOrder(BTNode root){
		if(root == null)
			return;
		Stack<BTNode> s1 = new Stack<>();
		Stack<BTNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			root = s1.pop();
			s2.push(root);
			if(root.left!=null)
				s1.push(root.left);
			if(root.right!=null)
				s1.push(root.right);
		}
		while(!s2.isEmpty()){
			root = s2.pop();
			System.out.print(root.data + " ");
		}
	}
	private void bfs(BTNode root){
		if(root == null)
			return;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()){
			BTNode temp = (BTNode) q.poll();
			System.out.print(temp.data + " ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		
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
	private void addRecursive(int value){
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

