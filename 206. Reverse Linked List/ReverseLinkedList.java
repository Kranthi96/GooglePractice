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
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode finalHead = null;
        while(head != null){
           ListNode temp = head.next;
           head.next = finalHead;
           finalHead = head;
           head = temp;
        }

        return finalHead;
        
    }
}
