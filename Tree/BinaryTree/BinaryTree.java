package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	private int data;
	private BinaryTree left, right;
	public BinaryTree(int data) {
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
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	public void PreOrderRec(BinaryTree root) {
		if(root!=null) {
			System.out.println(root.data);
			PreOrderRec(root.left);
			PreOrderRec(root.right);
		}
	}
	
	public void InOrderRec(BinaryTree root) {
		if(root!=null) {
			InOrderRec(root.left);
			System.out.println(root.data);
			InOrderRec(root.right);
		}
	}
	
	public void PostOrderRec(BinaryTree root) {
		if(root!=null) {
			PostOrderRec(root.left);
			PostOrderRec(root.right);
			System.out.println(root.data);
		}
	}
	
	public ArrayList<Integer> preOrderIterative(BinaryTree root){
		ArrayList<Integer> res= new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Stack<BinaryTree> s=new Stack<BinaryTree>();
		s.add(root);
		while(!s.isEmpty()) {
			BinaryTree tmp=s.pop();
			res.add(tmp.data);
			if(tmp.right!=null)
				s.push(tmp.right);
			if(tmp.left!=null)
				s.push(tmp.left);
			}
		return res;
		
	}
	
	public ArrayList<Integer> inOrderIterative(BinaryTree root){
		ArrayList<Integer> res= new ArrayList<Integer>();
		Stack<BinaryTree> s=new Stack<BinaryTree>();
		BinaryTree currentNode=root;
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
