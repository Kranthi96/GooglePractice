/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node ptr = head;
        while(ptr !=null){
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }

        ptr = head;

        while(ptr!=null){
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Node old_ptr_list = head;
        Node new_ptr_list = head.next;
        Node new_head = head.next;

        while(old_ptr_list!=null){
            old_ptr_list.next = old_ptr_list.next.next;
            new_ptr_list.next = (new_ptr_list.next !=null) ? new_ptr_list.next.next : null;
            old_ptr_list = old_ptr_list.next;
            new_ptr_list = new_ptr_list.next;


        }

        return new_head;
        
    }
}
