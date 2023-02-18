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

import java.util.*;

class Solution {
    // linked list를 합쳐서 sort하기
    // 일단 값 모두 합친 arraylist만들어서 sort하고 sort한 값으로 ListNode 만들기
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();

        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);

        if (list.size() == 0) {
            return null;
        }

        ListNode mergedList = null;

        for (int i = 0; i < list.size(); i += 1) {
            mergedList = new ListNode(list.get(list.size() - 1 - i), mergedList);
        }

        return mergedList;
    }
}
