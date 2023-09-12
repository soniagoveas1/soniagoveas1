import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class TreeNode{
	int value;
	TreeNode left, right;
	TreeNode(int v){
		value = v;
		left = null;
		right = null;
	}
}

class Tree{
	private final Random myRand;
	private TreeNode root;
	
	Tree(){
		root = null;
		myRand = new Random();
	}
	
	void add(int v){
		TreeNode n = new TreeNode(v);
		if(root == null){
			root = n;
			return;
		}
		TreeNode curr = root;
		while(curr.left != null && curr.right != null){
			if(pickLeft()){
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		
		int TreeSum(){
			return TreeSum(root);
		}
		private int TreeSum(TreeNode n){
			if(n == null){
				return 0;
			}
			return n.value + TreeSum(n.left) + TreeSum(n.right);
		}
		int TreeMin(){
			return TreeMin(root);
		}
		private int TreeMin(TreeNode n){
			int min = 0;
			if(n == null){
				return 0;
			} else {
				min = n.value;
			}
			return Math.min(min, Math.min(TreeMin(n.left), TreeMin(n.right)));
		}
		private boolean pickLeft(){
			return myRand.nextBoolean();
		}
		
	public class TestTree{
		static public void main(String[] args){
			Random myRand = new Random();
			Tree myTree = new Tree();
			
			for(int i = 0; i < 1000; i++){
				myTree.add(myRand.nextInt(5000) - 2500);
				}
				System.out.println(myTree.TreeMin());
			}
		}
	}
}