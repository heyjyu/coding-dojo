class Solution {
    // s가 t의 subsequece인지 반환하기
    // subsequence는 0개 이상을 삭제한 문자열이다. 이 때 순서는 보장된다.
    // 큐 이용해야될 것 같은데
    // t를 돌면서 s로 만든 큐에서 peek을해서 동일하면 디큐를 해서 t를 다 돌 때까지 모두 없어지면 true
    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i += 1) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i += 1) {
            if (queue.peek() == null) {
                return true;
            }

            if (queue.peek() == t.charAt(i)) {
                queue.remove();
            }
        }

        if (queue.size() == 0) {
            return true;
        }

        return false;
    }
}
