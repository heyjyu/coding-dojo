class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int middleIndex = (int) Math.ceil((double) (list.size() + 1) / 2) - 1;

        return list.get(middleIndex);
    }
}
