/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode middle=getMiddleNode(head);
        ListNode next=middle.next;
        middle.next=null;
        return mergeList(sortList(head),sortList(next));
        
    }
    ListNode getMiddleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode mergeList(ListNode lh,ListNode rh){
        ListNode p=new ListNode(0);
        ListNode temp=p;
        while(lh!=null&&rh!=null)
        {
            if(lh.val<rh.val)
            {
                temp.next=lh;
                lh=lh.next;
            }
            else
            {
                temp.next=rh;
                rh=rh.next;
            }
            temp=temp.next;
        }
        temp.next = lh!=null ? lh:rh;
        return p.next;
    }
}