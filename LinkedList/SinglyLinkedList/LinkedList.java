package SinglyLinkedList;

public class LinkedList {
	static  SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        SinglyLinkedListNode temp=new SinglyLinkedListNode(data);
        tail.next=temp;
        return head;
        
    }
	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        boolean a=true;
        while(head1!=null&&head2!=null){
            Integer b=head1.data;
            Integer c=head2.data;
            if(b.equals(c)){
                a=true;
            }
            else{
                a=false;
                break;
            }
            head1=head1.next;
            head2=head2.next;
            
        }
        if(head1!=null ||head2!=null)
            a=false;
        return a;

    }
	
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode temp;
		SinglyLinkedListNode temp1;
		if(head1.data<=head2.data) {
			temp=head1;
			temp1=head2;
		}
		else {
			temp=head2;
			temp1=head1;
		}
		SinglyLinkedListNode prev=null;
		while(temp!=null) {
			
			while(temp1!=null) {
				if(temp.data<=temp1.data) {
					prev=temp;
					temp=temp.next;
					
					break;
					
				}
				else {
					SinglyLinkedListNode t=new SinglyLinkedListNode(temp1.data);
					prev.next=t;
					t.next=temp;
					prev=prev.next;
						
				}
				if(temp.next==null) {
					while(temp1!=null) {
						temp1=temp1.next;
					}
				}
				temp1=temp1.next;
				
				
			}
			if(temp1==null)
				temp=temp.next;
				
			
			
		}
		return head1;
    }
	public static void main(String[] args) {
		SinglyLinkedListNode head=new SinglyLinkedListNode(1);
		SinglyLinkedListNode head1=new SinglyLinkedListNode(5);
		SinglyLinkedListNode head2=new SinglyLinkedListNode(8);
		SinglyLinkedListNode head3=new SinglyLinkedListNode(9);
		SinglyLinkedListNode head4=new SinglyLinkedListNode(10);
		head.next=head1;
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		SinglyLinkedListNode ead=new SinglyLinkedListNode(2);
		SinglyLinkedListNode ead1=new SinglyLinkedListNode(3);
		SinglyLinkedListNode ead2=new SinglyLinkedListNode(4);
		SinglyLinkedListNode ead3=new SinglyLinkedListNode(6);
		SinglyLinkedListNode ead4=new SinglyLinkedListNode(7);
		ead.next=ead1;
		ead1.next=ead2;
		ead2.next=ead3;
		ead3.next=ead4;
		SinglyLinkedListNode h=LinkedList.mergeLists(head,ead);
		while(h!=null) {
			System.out.println(h.data);
			h=h.next;
		}
		

	}

}
