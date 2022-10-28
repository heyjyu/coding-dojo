import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("unfinishedParticipant(new String[]{\"mislav\", \"stanko\", \"mislav\", \"ana\"}, new String[]{\"stanko\", \"ana\", \"mislav\"}): mislav = " +
                          unfinishedParticipant(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

        System.out.println("unfinishedParticipant(new String[]{\"marina\", \"josipa\", \"nikola\", \"vinko\", \"filipa\"}, new String[]{\"josipa\", \"filipa\", \"marina\", \"nikola\"}): vinko = " +
                          unfinishedParticipant(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }

    public String solution(String[] participant, String[] completion) {
        // test();

        String answer = unfinishedParticipant(participant, completion);
        System.out.println(answer);
        return answer;
    }

    public String unfinishedParticipant(String[] participant, String[] completion) {
        String[] sortedParticipant = Arrays.stream(participant).sorted().toArray(String[]::new);
        String[] sortedCompletion = Arrays.stream(completion).sorted().toArray(String[]::new);

        int unfinishedIndex = IntStream.range(0, sortedCompletion.length)
            .filter(i -> !sortedParticipant[i].equals(sortedCompletion[i]))
            .findFirst()
            .orElse(-1);

        return unfinishedIndex == -1 ? sortedParticipant[sortedParticipant.length - 1] : sortedParticipant[unfinishedIndex];
    }
}
