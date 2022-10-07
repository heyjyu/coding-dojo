import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        int answer = process(dartResult);
        return answer;
    }

    public List<String> splitRound(String string) {
        List<String> rounds = new ArrayList<>();

        Pattern pattern = Pattern.compile("[0-9]{1,2}[SDT][*#]?");

        Matcher matcher = pattern.matcher(string);

        while(matcher.find()) {
            rounds.add(matcher.group());
        }

        return rounds;
    }

    public int process(String string) {
        List<String> results = splitRound(string);

        List<Integer> values = new ArrayList<>();

        for (String result : results) {
            String[] words = result.split("[SDT]");

            int score = Integer.valueOf(words[0]);

            Pattern pattern = Pattern.compile("[SDT]");

            Matcher matcher = pattern.matcher(result);

            int bonus = 1;

            if (matcher.find()) {
                if (matcher.group().equals("D")) {
                    bonus = 2;
                }

                if (matcher.group().equals("T")) {
                    bonus = 3;
                }
            }

            values.add((int) Math.pow(score, bonus));

            if (words.length == 1) {
                continue;
            }

            if (words[1].equals("*")) {
                int lastIndex = values.size() - 1;
                values.set(lastIndex, values.get(lastIndex) * 2);

                if (lastIndex > 0) {
                    values.set(lastIndex - 1, values.get(lastIndex - 1) * 2);
                }
            }

            if (words[1].equals("#")) {
                int lastIndex = values.size() - 1;
                values.set(lastIndex, -values.get(lastIndex));
            }
        }

        return values.stream().mapToInt(i -> i).sum();
    }
}
