/**
 * 
 */
package regex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * @author Sudhansu
 * Create a family ancestor tree using n-ary tree
 *
 */
public class AncestorTree {


	Family root;
	List<Family> leftOvers = new ArrayList<Family>();
	Family createANode(String name){
		Family n = new Family();
		n.name = name;
		n.parent = null;
		n.child = new ArrayList<Family>();
		return n;
		
		
	}
	Family createTree(Family root,String parent, String name){
		if(root == null){
			root = createANode(parent);
			root.child.add(createANode(name));
			return root;
		}
		Family p = findParent(root,parent);
		Family c = findParent(root,name);
		//print(p);
		// If both parent and child are null then return null and add the relation to leftovers
		if(p==null && c == null)
			return null;
		if(p==null){
			if(c.name.equals(root.name)){
				Family temp = root;
				root = createANode(parent);
				root.child.add(temp);
			}
			return root;
				
		}
		else
			p.child.add(createANode(name));
		return root;
			
	}
	
	Family findParent(Family root, String name){
		if (root == null || name == null)
			return null;
		if(root.name.equals(name))
			return root;
		for (Family c : root.child) {
			Family node = findParent(c, name);
			if(node!=null) return node;
		}
		return null;		
	}
	public static void main(String[] args) {

		String format = "John Doe , Mary Smith" + "\n" + "Brian William , John Doe" + "\n" + "Brian William ,Robert Andrew" + "\n" + "Mary Smith , Max Jackson";
		String regex = "\\n";
		Pattern p = Pattern.compile(regex);
		String [] items  = p.split(format);
		String regex1 = "\\s*,\\s*";
		AncestorTree f = new AncestorTree();
		for (String string : items) {
			String [] arr = string.split(regex1);
//			if(family==null)
//				System.out.println("Holy crap!");
			f.root = f.createTree(f.root, arr[0], arr[1]);
		}
			f.levelOrder(f.root);
			System.out.println();
			f.findAncestor(f.root, "Max Jackson");
//			Family n = f.findParent(f.root, "John Doe");
//			System.out.println(n);

	}
	
/**	public void inOrder(Family root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.name + " ");
		inOrder(root.right);
	}*/
	public void levelOrder(Family root){
		if(root == null)
			return;
		Queue<Family> q= new LinkedList<Family>();
		q.add(root);
		while(!q.isEmpty()){
			Family temp = q.remove();
			if(temp!=null)
				System.out.print(temp.name + ",");
			for(Family f: temp.child){
				q.add(f);
			}
		}
	}
	public boolean findAncestor(Family root, String s){
		if(root == null)
			return false;
		else if(root.name.equals(s))
			return true;
		else{
			for (Family f : root.child) {
				if(findAncestor(f, s)){
					System.out.print(root.name+ " , ");
					return true;
				}
			}
		}
		return false;
	}
	
}

class Family{
	 String name;
	 List <Family> child = new ArrayList<Family>();
	 Family parent;
}
