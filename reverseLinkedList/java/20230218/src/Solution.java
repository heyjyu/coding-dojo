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
class Solution {
    // next에 추가하기
    public ListNode reverseList(ListNode head) {
        ListNode list = null;

        while(head != null) {
            list = new ListNode(head.val, list);
            head = head.next;
        }

        return list;
    }
}
