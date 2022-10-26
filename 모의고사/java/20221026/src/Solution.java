import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("scores(new int[]{1,2,3,4,5}): new int{5,0,0} = ");
        Arrays.stream(scores(new int[]{1, 2, 3, 4, 5})).forEach(System.out::println);

        System.out.println("score(new int[]{1,2,3,4,5,2}, new int[]{1,2,3,4,5}): 5 = "
                + score(new int[]{1, 2, 3, 4, 5, 2}, new int[]{1, 2, 3, 4, 5}));

        System.out.println("best(new int[]{1,3,2,4,2}): new int[]{1,2,3} = ");
        Arrays.stream(best(new int[]{1, 3, 2, 4, 2})).forEach(System.out::println);
    }

    public int[] solution(int[] answers) {
        // test();

        int[] answer = best(answers);
        return answer;
    }

    public int[] scores(int[] answers) {
        int[][] guesses = new int[][]{{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        return IntStream.range(0, guesses.length)
                .map(i -> score(answers, guesses[i]))
                .toArray();
    }

    public int score(int[] answers, int[] guesses) {
        return IntStream.range(0, answers.length)
                .reduce(0, (score, i) -> guesses[i % guesses.length] == answers[i] ? score + 1 : score);
    }

    public int[] best(int[] answers) {
        int[] scores = scores(answers);
        int highestScore = Arrays.stream(scores).max().getAsInt();

        return IntStream.range(0, scores.length)
                .filter(i -> scores[i] == highestScore)
                .map(i -> i + 1)
                .toArray();
    }
}
