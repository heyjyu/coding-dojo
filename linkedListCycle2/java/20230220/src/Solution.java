// cycle의 시작점 찾기
// 2 0 -4 2 0 -4
// 2의 next는 0 -4 2 0 -4 2 0 -4 2
// 2 0 -4 2 0 -4
// 2의 val과 next를 하다가 둘이 동일해지면 cycle
// 일단은 0부터 10^4까지 돌면서 각 val이 null이 아닐 때 cycle에 해당하는지 확인하자

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode list1 = head;

        for (int i = 0; i <= Math.pow(10, 4); i += 1) {
            if (list1 == null) {
                return null;
            }

            ListNode list2 = list1.next;

            for (int j = i + 1; j <= Math.pow(10, 4); j += 1) {
                if (list2 == null) {
                    return null;
                }

                if (list1 == list2) {
                    return list1;
                };

                list2 = list2.next;
            }

            list1 = list1.next;
        }

        return null;
    }
}
