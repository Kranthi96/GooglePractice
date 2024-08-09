/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp != null){
            ListNode temp2 = temp;
            while(temp2.next!=null && temp2.val == temp2.next.val)
                temp2=temp2.next;
            temp.next = temp2.next;
            temp = temp.next;
        }



        return head;

        
    }
}
