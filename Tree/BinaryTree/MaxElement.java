package BinaryTree;

import java.util.Stack;

public class MaxElement {

	public int maxInBinaryTreeRec(BinaryTree root) {
		int maxElement=Integer.MIN_VALUE;
		if(root!=null) {
		int leftMax=maxInBinaryTreeRec(root.left);
		int rightMax=maxInBinaryTreeRec(root.right);
		if(leftMax>maxElement)
			maxElement=leftMax;
		else
			maxElement=rightMax;
		
		
		if(root.data>maxElement)
			maxElement=root.data;
		}
		return maxElement;
	}
	
	public int maxInBinaryTreeItr(BinaryTree root) {
		int max=Integer.MIN_VALUE;
		if(root!=null) {
			Stack<BinaryTree> s= new Stack<BinaryTree>();
			s.push(root);
			while(true) {
				BinaryTree node=s.pop();
				if(node.getRight()!=null)
					s.push(node.getRight());
				if(node.getLeft()!=null)
					s.push(node.getLeft());
				if (node.getData()>max) 
					max=node.getData();
				if (s.isEmpty()) 
					break;
				}
			}
			return max;
	}
	public static void main(String[] args) {
		MaxElement maxElement=new MaxElement();
		BinaryTree binaryTreeNode=new BinaryTree(2);
		binaryTreeNode.setLeft(new BinaryTree(3));
		binaryTreeNode.setRight(new BinaryTree(4));
		binaryTreeNode.getLeft().setLeft(new BinaryTree(9));
		System.out.println(maxElement.maxInBinaryTreeRec(binaryTreeNode));
		System.out.println(maxElement.maxInBinaryTreeItr(binaryTreeNode));

	}
}
