package BinarySearchTree;

import java.util.Stack;

class Node{
	int data;
	Node left=null;
	Node right= null;
	Node(int data) {
		this.data=data;	
	}
}
public class BinarySearchTree {
	Node root;

	public BinarySearchTree() {
		this.root = null;
	}
	
	public void insert(int data) {
		Node newnode= new Node(data);
		if(this.root==null)
			this.root=newnode;
		else {
			Node currentNode=root;
			while(true) {
				if(newnode.data<currentNode.data) {
					if(currentNode.left==null) {
						currentNode.left=newnode;
						break;
					}
					currentNode=currentNode.left;
				}
				else {
					if(currentNode.right==null) {
						currentNode.right=newnode;
						break;
					}
					currentNode=currentNode.right;
				}
				
			}
		}
	}
	
	public void display() {
		Node temp=this.root;
			if(temp==null)
				System.exit(0);
			
			else {
				Stack<Node> s= new Stack<Node>();
				s.push(temp);
				while(!s.isEmpty()) {
					Node tNode=s.pop();
					System.out.println(tNode.data);
					if(tNode.right!=null)
						s.push(tNode.right);
					if(tNode.left!=null)
						s.push(tNode.left);
			
				}
			}
		}
	
	public static void main(String[] args) {
		BinarySearchTree b=new BinarySearchTree();
		b.insert(9);
		b.insert(4);
		b.insert(6);
		b.insert(20);
		b.insert(170);
		b.insert(15);
		b.insert(1);
		b.display();
		
		
	}

}
