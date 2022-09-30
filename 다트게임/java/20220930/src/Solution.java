import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String dartResult) {
        int answer = process(dartResult);
        return answer;
    }

    public List<String> splitRound(String string) {
        String[] characters = string.split("");
        List<String> results = new ArrayList<>();

        String roundResult = "";

        for (int i = 0; i < characters.length; i += 1) {
            if (roundResult.length() == 0) {
                roundResult = characters[i];

                continue;
            }

            if (List.of("S", "D", "T").contains(roundResult.substring(roundResult.length() - 1))) {
                if (List.of("*", "#").contains(characters[i])) {
                    roundResult += characters[i];
                    results.add(roundResult);
                    roundResult = "";

                    continue;
                }

                results.add(roundResult);
                roundResult = characters[i];

                continue;
            };

            roundResult += characters[i];
        }

        if (!roundResult.equals("")) {
            results.add(roundResult);
        }

        return results;
    }

    public List<Integer> scores(String string) {
        List<String> results = splitRound(string);
        List<Integer> scores = new ArrayList<>();

        for (String result : results) {
            String score = "";
            for (int i = 0; i < result.length(); i += 1) {
                if (List.of("S","D","T").contains(result.substring(i, i + 1))) {
                    scores.add(Integer.valueOf(score));

                    break;
                }

                score += result.substring(i, i + 1);
            }
        }

        return scores;
    }

    public List<String> bonuses(String string) {
        List<String> results = splitRound(string);
        List<String> bonuses = new ArrayList<>();

        for (String result : results) {
            for (int i = 0; i < result.length(); i += 1) {
                if (List.of("S","D","T").contains(result.substring(i, i + 1))) {
                    bonuses.add(result.substring(i, i + 1));

                    break;
                }
            }
        }

        return bonuses;
    }

    public List<String> options(String string) {
        List<String> results = splitRound(string);
        List<String> options = new ArrayList<>();

        for (String result : results) {
            String lastCharacter = result.substring(result.length() - 1);

            if (List.of("*", "#").contains(lastCharacter)) {
                options.add(lastCharacter);

                continue;
            }

            options.add("");
        }

        return options;
    }

    public List<Integer> processBonus(String string) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < splitRound(string).size(); i += 1) {
            int powerBy = 1;

            if (bonuses(string).get(i).equals("D")) {
                powerBy = 2;
            }

            if (bonuses(string).get(i).equals("T")) {
                powerBy = 3;
            }

            results.add((int) Math.pow(scores(string).get(i), powerBy));
        }

        return results;
    }

    public int process(String string) {
        List<Integer> results = processBonus(string);
        int sum = 0;

        for (int i = 0; i < splitRound(string).size(); i += 1) {
            if (options(string).get(i).equals("*")) {
                results.set(i, results.get(i) * 2);

                if (i > 0) {
                    results.set(i - 1, results.get(i - 1) * 2);
                }
            }

            if (options(string).get(i).equals("#")) {
                results.set(i, results.get(i) * (-1));
            }
        }

        for (Integer result : results) {
            sum += result;
        }

        return sum;
    }
}
