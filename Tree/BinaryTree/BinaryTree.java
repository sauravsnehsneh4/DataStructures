package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public int data;
	public BinaryTree left, right;
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
	
	public ArrayList<Integer> postOrderIterative(BinaryTree root){
		ArrayList<Integer> res=new ArrayList<>();
		if (root==null)
			return res;
		Stack<BinaryTree> s=new Stack<BinaryTree>();
		s.push(root);
		BinaryTree prev=null;
		while(!s.isEmpty()) {
			BinaryTree curr=s.peek();
			if(prev==null || prev.left==curr || prev.right==curr) {
				if(curr.left!=null)
					s.push(curr.left);
				else if(curr.right!=null)
					s.push(curr.right);
			}	
			else if(curr.left==prev) {
				if(curr.right!=null)
					s.push(curr.right);	
			}
			else {
				res.add(curr.data);
				s.pop();
			}
			prev=curr;
			}
		return res;
		}
	
	public ArrayList<Integer> levelOrderIterative(BinaryTree root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Queue<BinaryTree> q=new LinkedList<BinaryTree>();
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> curr=new ArrayList<Integer>();
		while(!q.isEmpty()) {
			BinaryTree temp=q.poll();
			if(temp!=null) {
				curr.add(temp.data);
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
			}else {
				ArrayList<Integer> c_curr=new ArrayList<Integer>(curr);
				res.addAll(curr);
				curr.clear();
				if(!q.isEmpty())
					q.offer(null);
			}
			
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		BinaryTree b=new BinaryTree(1);
		b.setLeft(new BinaryTree(2));
		b.setRight(new BinaryTree(3));
		b.getLeft().setLeft(new BinaryTree(4));
		b.getLeft().setRight(new BinaryTree(5));
		b.getRight().setLeft(new BinaryTree(6));
		b.getRight().setRight(new BinaryTree(7));
		b.PreOrderRec(b);
		System.out.println("-----------------");
		System.out.println(b.levelOrderIterative(b).toString());

	}
}

