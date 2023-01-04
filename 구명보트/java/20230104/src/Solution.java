import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        ArrayDeque<Integer> deque = new ArrayDeque<>(50505);

        for(int person : people) {
            deque.add(person);
        }

        int answer = 0;

        while(!deque.isEmpty()) {
            int weight = deque.pollLast();

            if(deque.isEmpty() == false && weight + deque.peekFirst() <= limit) {
                deque.pollFirst();
            }

            answer += 1;
        }

        return answer;
    }
}
