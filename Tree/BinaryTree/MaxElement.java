package BinaryTree;

import java.util.Stack;

public class MaxElement {

	public int maxInBinaryTreeRec(BinaryTreeNode root) {
		int max=0;
		if(root!=null) {
			int left=maxInBinaryTreeRec(root.getLeft());
			int right=maxInBinaryTreeRec(root.getRight());
			if(left>right)
				max=left;
			else{
				max=right;	
			}
			if(root.getData()>max)
				max=root.getData();
		}
			return max;
	}
	
	public int maxInBinaryTreeItr(BinaryTreeNode root) {
		int max=Integer.MIN_VALUE;
		if(root!=null) {
			Stack<BinaryTreeNode> s= new Stack<BinaryTreeNode>();
			s.push(root);
			while(true) {
				BinaryTreeNode node=s.pop();
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
		BinaryTreeNode binaryTreeNode=new BinaryTreeNode(2);
		binaryTreeNode.setLeft(new BinaryTreeNode(3));
		binaryTreeNode.setRight(new BinaryTreeNode(4));
		binaryTreeNode.getLeft().setLeft(new BinaryTreeNode(9));
		System.out.println(maxElement.maxInBinaryTreeRec(binaryTreeNode));
		System.out.println(maxElement.maxInBinaryTreeItr(binaryTreeNode));

	}
}
