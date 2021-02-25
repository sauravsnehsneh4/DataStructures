package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left, right;
	public BinaryTreeNode(int data) {
		super();
		this.data = data;
		this.left= null;
		this.right= null;
		
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public void PreOrderRec(BinaryTreeNode root) {
		if(root!=null) {
			System.out.println(root.data);
			PreOrderRec(root.left);
			PreOrderRec(root.right);
		}
	}
	
	public void InOrderRec(BinaryTreeNode root) {
		if(root!=null) {
			InOrderRec(root.left);
			System.out.println(root.data);
			InOrderRec(root.right);
		}
	}
	
	public void PostOrderRec(BinaryTreeNode root) {
		if(root!=null) {
			PostOrderRec(root.left);
			PostOrderRec(root.right);
			System.out.println(root.data);
		}
	}
	
	public ArrayList<Integer> preOrderTraversal(BinaryTreeNode root){
		ArrayList<Integer> res= new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.add(root);
		while(!s.isEmpty()) {
			BinaryTreeNode tmp=s.pop();
			res.add(tmp.data);
			if(tmp.right!=null)
				s.push(tmp.right);
			if(tmp.left!=null)
				s.push(tmp.left);
			}
		return res;
		
	}
	
	public ArrayList<Integer> inOrderTraversal(BinaryTreeNode root){
		ArrayList<Integer> res= new ArrayList<Integer>();
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode=root;
		boolean done=false;
		while(!done) {
			if (currentNode!=null) {
				s.push(currentNode);
				currentNode=currentNode.left;
			}
			else {
				if(s.isEmpty())
					done=true;
				else {
					currentNode=s.pop();
					res.add(currentNode.data);
					currentNode=currentNode.right;
				}
			}
		}
		return res;
		
	}
	
	

}
