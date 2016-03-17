/**
 * 
 */
package regex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;


/**
 * @author Sudhansu
 * create family ancestor tree using binary tree
 */
public class FamilyTree {
	Node root;
	Node createANode(String name){
		Node n = new Node();
		n.name = name;
		n.left = n.right = null;
		return n;
		
		
	}
	Node createTree(Node root,String parent, String name){
		if(root == null){
			root = createANode(parent);
			root.left=createANode(name);
			return root;
		}
		Node p = findParent(root,parent);
		Node c = findParent(root,name);
		//print(p);
		if(p==null){
			if(c.name.equals(root.name)){
				Node temp = root;
				root = createANode(parent);
				root.left = temp;
			}
			return root;
				
		}
		if(p.left==null)
			p.left = createANode(name);
		else
			p.right = createANode(name);
		return root;
			
	}
	void print (Node p){
		System.out.print(p.name+ " ");
		if(p.left!=null){
			System.out.print(p.left.name + " ");
		}
		else{
			System.out.print("-"+" ");
		}
		if(p.right!=null){
			System.out.print(p.right.name +  " ");
		}
		else{
			System.out.print(" " + " ");
		}
		System.out.println();
	}
	Node findParent(Node root, String name){
		if (root == null || name == null)
			return null;
		if(root.name.equals(name))
			return root;
		Node l = findParent(root.left, name);
		Node r = findParent(root.right, name);
		return (l!=null)?l:r;
				
	}
	public static void main(String[] args) {
		String format = "John Doe , Mary Smith" + "\n" + "Brian William , John Doe" + "\n" + "Brian William ,Robert Andrew" + "\n" + "Mary Smith , Max Jackson";
		String regex = "\\n";
		Pattern p = Pattern.compile(regex);
		String [] items  = p.split(format);
		String regex1 = "\\s*,\\s*";
		FamilyTree f = new FamilyTree();
		for (String string : items) {
			String [] arr = string.split(regex1);
			f.root = f.createTree(f.root, arr[0], arr[1]);
		}
			f.levelOrder(f.root);
			System.out.println();
			f.findAncestor(f.root, "Max Jackson");
//			Node n = f.findParent(f.root, "John Doe");
//			System.out.println(n);

	}
	
	public void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.name + " ");
		inOrder(root.right);
	}
	public void levelOrder(Node root){
		if(root == null)
			return;
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp!=null)
				System.out.print(temp.name + ",");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	public boolean findAncestor(Node root, String s){
		if(root == null)
			return false;
		else if(root.name.equals(s))
			return true;
		else if(findAncestor(root.left, s) || findAncestor(root.right, s))
		{
			System.out.print(root.name + " ");
			return true;
		}
		return false;
	}
	
}

class Node{
	 String name;
	 Node left;
	 Node right;
}
