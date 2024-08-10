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
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        while(head.next != null){
           if(head.next.next == null)
            {
                head = head.next;
            }else{
                
                head= head.next.next;
            }
            mid = mid.next;

        }

        return mid;
        
    }
}
