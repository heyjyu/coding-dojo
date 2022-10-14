import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = sort(N, stages);
        return answer;
    }

    public int totalPlayerNumber(int stage, int[] stages) {
        return (int) Arrays.stream(stages)
                .filter(i -> i >= stage)
                .count();
    }

    public int failedPlayerNumber(int stage, int[] stages) {
        return (int) Arrays.stream(stages)
                .filter(i -> i == stage)
                .count();
    }

    public double failure(int stage, int[] stages) {
        if (totalPlayerNumber(stage, stages) == 0) {
            return 0.0;
        }

        return Double.valueOf(failedPlayerNumber(stage, stages)) / totalPlayerNumber(stage, stages);
    }

    public int[] sort(int numberOfStages, int[] stages) {
        Double[] failures = IntStream.rangeClosed(1, numberOfStages)
                .mapToDouble(stage -> failure(stage, stages))
                .boxed()
                .toArray(Double[]::new);

        Integer[] index = IntStream.range(0, numberOfStages).boxed().toArray(Integer[]::new);

        Arrays.sort(index, (o1, o2) -> Double.compare(failures[o2], failures[o1]));

        return Arrays.stream(index).mapToInt(i -> i + 1).toArray();
    }
}
