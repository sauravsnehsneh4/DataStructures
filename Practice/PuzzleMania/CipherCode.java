package PuzzleMania;

import java.io.*;
import java.util.*;
class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }
}
public class CipherCode
{
    public static Node find(Node node,int value){
        while(node!=null){
            if(node.value==value)
                break;
            node=node.next;
        }
        return node;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int inputint = s.nextInt();
        int len=inputString.length();
        Node head=new Node(65);
        Node temp=head;
        for (int i=66;i<=90;i++){
           Node x=new Node(i);
            temp.next=x;
            x.prev=temp;
            temp=temp.next;
        }
        temp.next=head;
        head.prev=temp;
        
        Node head1=new Node(97);
        Node temp1=head1;
        for (int i=98;i<=122;i++){
           Node x=new Node(i);
            temp1.next=x;
            x.prev=temp1;
            temp1=temp1.next;
        }
        temp1.next=head1;
        head1.prev=temp1;
        Node m;
        for(int i=0;i<len;i++){
            char c=inputString.charAt(i);
            int ascii=c;
            if(ascii>=65 && ascii<=90){
                Node n=find(head,ascii);
                if(inputint>=0){
                    m=increment(n,inputint);
                }
                else{
                    m=decrement(n,inputint);
                }
                char oldChar=inputString.charAt(i);
                inputString=inputString.replace(oldChar, (char) m.value);
                
            }
            if (ascii>=97 && ascii<=122){
               Node n=find(head1,ascii);
                if(inputint>=0){
                    m=increment(n,inputint);
                }
                else{
                    m=decrement(n,inputint);
                }
                char oldChar=inputString.charAt(i);
                inputString=inputString.replace(oldChar, (char) m.value);
            }
            
        }
        
        
        
        System.out.println(inputString);
    }
	private static Node decrement(Node n, int inputint) {
		// TODO Auto-generated method stub
		for(int i=0;i>inputint;i--) {
			n=n.prev;
		}
		return n;
	}
	private static Node increment(Node n, int inputint) {
		// TODO Auto-generated method stub
		for(int i=0;i<inputint;i++) {
			n=n.next;
		}
		return n;
	}
}
