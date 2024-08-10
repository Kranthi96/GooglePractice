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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode result= null,curr=null;
        while(list1 != null && list2!=null){
            ListNode temp= null;
            if(list1.val <= list2.val)
            {
                temp = list1;
                list1=list1.next;
            }else{
                temp = list2;
                list2 = list2.next;
            }
            if(result == null){
                result = temp;
                curr = temp;
            }else{
                curr.next = temp;
                curr = temp;
            }
        }

        while(list1 !=null){
            if(result == null){
                result = list1;
                curr = list1;
            }else{
                curr.next = list1;
                curr = list1;
            }
            list1 = list1.next;
            
        }
        while(list2 !=null){
            if(result == null){
                result = list2;
                curr = list2;
            }else{
                curr.next = list2;
                curr = list2;
            }
            list2 = list2.next;
        }
        return result;
    }
}
