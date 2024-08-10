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
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n == 1) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count =1;
        ListNode curr = dummy;
        while(count <=n+1){
            curr = curr.next;
            count++;
        }

        ListNode prev = dummy;

        while(curr !=null){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
            
        
        
    }
}
