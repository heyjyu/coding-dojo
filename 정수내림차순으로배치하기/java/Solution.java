import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        long answer = sort(n);
        return answer;
    }

    public long sort(long number) {
        return Long.parseLong(Arrays.stream(String.valueOf(number).split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}
